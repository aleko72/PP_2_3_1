package org.example.crud.dao;

import org.example.crud.models.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    void save(User user);

    void update(int id, User user);

    void delete(int id);
}