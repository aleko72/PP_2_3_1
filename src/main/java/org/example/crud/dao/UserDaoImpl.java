package org.example.crud.dao;

import org.example.crud.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager
                .createQuery("Select u From User u", User.class)
                .getResultList();
    }

    @Override
    public User getUserById(int id) {
       return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }


    @Override
    public void update(long id, User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
