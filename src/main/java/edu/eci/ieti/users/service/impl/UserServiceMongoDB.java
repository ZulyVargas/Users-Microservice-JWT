package edu.eci.ieti.users.service.impl;


import edu.eci.ieti.users.entities.User;
import edu.eci.ieti.users.repository.UserRepository;
import edu.eci.ieti.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceMongoDB  implements UserService {

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user )
    {
        userRepository.save(user);
        return user;
    }

    @Override
    public User findById( String id )
    {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    @Override
    public void deleteById( String id )
    {
        userRepository.deleteById(id);
    }

    @Override
    public User update( User user, String id )
    {
        userRepository.save(user);
        return userRepository.findById(id).get();
    }

    //Challenge Yourself point (3 guia)
    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        return  userRepository.findByNameOrLastNameLike(queryText,queryText);
    }

    @Override
    public List<User> findUsersCreatedAfter(String startDate){
        return  userRepository.findByCreatedAtGreaterThan(startDate);

    }


}
