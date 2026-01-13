package com.winterflame.aura.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winterflame.aura.entity.User;
import com.winterflame.aura.entity.Vibe;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class VibeRepository implements VibeDAO {

    private final EntityManager entityManager;

    @Autowired
    public VibeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public int save(Vibe vibe) {
        entityManager.persist(vibe);
        if (vibe.isHasNotes() && vibe.getDayHealth() != null) {
            vibe.getDayHealth().vibe = vibe;
            entityManager.persist(vibe.getDayHealth());
        }
        return vibe.getVibeId();
    }

    @Override
    @Transactional
    public int update(Vibe vibe) {
        entityManager.merge(vibe);

        if (vibe.isHasNotes() && vibe.getDayHealth() != null) {
            vibe.getDayHealth().vibe = vibe;
            if (vibe.getDayHealth().healthEntryId == 0) {
                entityManager.persist(vibe.getDayHealth());
            } else {
                entityManager.merge(vibe.getDayHealth());
            }
        }

        return vibe.getVibeId();
    }

    @Override
    @Transactional
    public void delete(int vibeId) {
        Vibe vibe = entityManager.find(Vibe.class, vibeId);

        // Delete associated DayHealth entries first
        entityManager.createQuery("DELETE FROM DayHealth WHERE vibe.vibeId = :vibeId")
                .setParameter("vibeId", vibeId)
                .executeUpdate();

        entityManager.remove(vibe);
    }

    @Override
    public Vibe getById(int vibeId) {
        return entityManager.find(Vibe.class, vibeId);
    }

    @Override
    public List<Vibe> getAll(User user) {
        TypedQuery<Vibe> query = entityManager.createQuery("FROM Vibe WHERE user = :user ORDER BY date", Vibe.class);
        query.setParameter("user", user);
        return query.getResultList();
    }

    @Override
    public Vibe getByDateForUser(LocalDate date, User user) {
        TypedQuery<Vibe> query = entityManager.createQuery("From Vibe WHERE date=:date AND user=:user", Vibe.class);
        query.setParameter("date", date);
        query.setParameter("user", user);
        query.setMaxResults(1);
        List<Vibe> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public List<Vibe> getVibesForMonthByUser(int month, int year, User user) {
        TypedQuery<Vibe> query = entityManager.createQuery(
                "FROM Vibe WHERE MONTH(date) = :month AND YEAR(date) = :year AND user = :user ORDER BY date",
                Vibe.class);
        query.setParameter("month", month);
        query.setParameter("year", year);
        query.setParameter("user", user);
        return query.getResultList();
    }

    @Override
    public List<Vibe> getVibesForYearByUser(int year, User user) {
        TypedQuery<Vibe> query = entityManager.createQuery(
                "FROM Vibe WHERE YEAR(date) = :year AND user = :user ORDER BY date",
                Vibe.class);
        query.setParameter("year", year);
        query.setParameter("user", user);
        return query.getResultList();
    }
}
