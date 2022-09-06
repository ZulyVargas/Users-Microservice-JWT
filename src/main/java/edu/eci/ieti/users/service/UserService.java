package edu.eci.ieti.users.service;

import java.util.List;

import edu.eci.ieti.users.entities.User;

public interface UserService {

    
    User create( User user );

    User findById( String id );
     
    List<User> getAll();

    void deleteById( String id );

    User update( User user, String userId );

    List<User> findUsersWithNameOrLastNameLike(String queryText);

    List<User> findUsersCreatedAfter(String startDate);

    User findByEmail(String email);




}
