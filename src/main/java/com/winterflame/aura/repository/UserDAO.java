package com.winterflame.aura.repository;

import java.util.List;

import com.winterflame.aura.entity.User;

public interface UserDAO {

    public int save(User user);

    public int update(User user);

    public void delete(int userId);

    public User getById(int userId);

    public List<User> getAll();

}
