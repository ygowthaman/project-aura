package com.winterflame.aura.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winterflame.aura.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class UserRepository implements UserDAO {

    private final EntityManager entityManager;

    @Autowired
    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public int save(User user) {
        entityManager.persist(user);
        return user.getId();
    }

    @Override
    @Transactional
    public int update(User user) {
        entityManager.merge(user);
        return user.getId();
    }

    @Override
    @Transactional
    public void delete(int userId) {
        User user = entityManager.find(User.class, userId);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public User getById(int userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }
}
