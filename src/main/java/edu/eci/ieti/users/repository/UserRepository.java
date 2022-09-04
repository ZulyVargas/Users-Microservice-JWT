package edu.eci.ieti.users.repository;

import edu.eci.ieti.users.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String>
{

    List<User> findByNameOrLastNameLike(String regexp, String regexpTwo);

    List<User> findByCreatedAtGreaterThan(String startDate);

}