package org.example.crud.dao;

import org.example.crud.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    private static int USER_ID = 0;
    private List<User> users;

    public UserDaoImpl() {
        users = new ArrayList<>();
        users.add(new User(++USER_ID, "Alex", "Kolushkin", 50));
        users.add(new User(++USER_ID, "Alex", "Vladimirov", 51));
        users.add(new User(++USER_ID, "Oleg", "Bekun", 55));
        users.add(new User(++USER_ID, "Olga", "Kolushkina", 48));
        users.add(new User(++USER_ID, "Victoria", "Kolushkina", 19));
    }

    @Override
    public List<User> getUsers(){
        return users;
    }

    @Override
    public User getUserById(int id){
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(User user) {
        user.setId(++USER_ID);
        users.add(user);
    }

    @Override
    public void update(int id, User user) {
        User userUpdated = getUserById(id);
        userUpdated.setName(user.getName());
        userUpdated.setLastName(user.getLastName());
        userUpdated.setAge(user.getAge());
    }

    @Override
    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
