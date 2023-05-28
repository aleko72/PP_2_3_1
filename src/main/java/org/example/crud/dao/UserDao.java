package org.example.crud.dao;

import org.example.crud.models.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(long id);

    void save(User user);

    void update(long id, User user);

    void delete(long id);
}
