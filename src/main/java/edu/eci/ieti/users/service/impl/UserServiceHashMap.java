package edu.eci.ieti.users.service.impl;


import edu.eci.ieti.users.entities.User;
import edu.eci.ieti.users.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

//@Service
public class UserServiceHashMap implements UserService {
    HashMap <String, User> users = new HashMap();

    @Override
    public User create(User user) {
        users.put(user.getId(),user);
        return users.get(user.getId()) ;
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }

    @Override
    public List<User> getAll() {
        List<User> listUsers = new ArrayList<>(users.values());
        return listUsers;
    }

    @Override
    public void deleteById(String id){
        users.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        users.replace(userId, user);
        return users.get(userId);
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        return null;
    }

    @Override
    public List<User> findUsersCreatedAfter(String startDate) {
        return null;
    }

    @Override
    public User findByEmail(String email) {

        for (User u : users.values()){
            if (u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }


}
