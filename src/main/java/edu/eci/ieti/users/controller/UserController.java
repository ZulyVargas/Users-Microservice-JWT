package edu.eci.ieti.users.controller;


import edu.eci.ieti.users.dto.UserDto;
import edu.eci.ieti.users.entities.User;
import edu.eci.ieti.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( "/api/v1/user" )
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        //Get list of users and map them to dto users
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<UserDto> usersDTO = new ArrayList<>();
            List<User> userList = userService.getAll();

            for (User user : userList) {
                usersDTO.add(modelMapper.map(user, UserDto.class));
            }
            return new ResponseEntity<>(usersDTO, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping( "/{id}" )
    public ResponseEntity<UserDto> findById(@PathVariable String id ) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            userService.findById(id);
            return new ResponseEntity<>(modelMapper.map(userService.findById(id), UserDto.class), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<UserDto> create( @RequestBody UserDto userDto ) {
        try {
            //ModelMapper modelMapper = new ModelMapper();
            //Change to add the password
            //userService.create(modelMapper.map(userDto, User.class));
            User newUser = new User(userDto);
            userService.create(newUser);
            return new ResponseEntity<>(userDto, HttpStatus.ACCEPTED);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<UserDto> update( @RequestBody UserDto user, @PathVariable String id ) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            userService.update(modelMapper.map(user, User.class), id);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        try {
            userService.deleteById(id);
            return new ResponseEntity<>(true , HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    //Challenge Yourself point

    @GetMapping("/likeName/{queryText}")
    public ResponseEntity<List<UserDto>> findUsersWithNameOrLastNameLike(@PathVariable String queryText) {

        try {
            ModelMapper modelMapper = new ModelMapper();
            List<User> users = userService.findUsersWithNameOrLastNameLike(queryText);
            List<UserDto> usersDTOLike = new ArrayList<>();
            for (User user : users) {
                usersDTOLike.add(modelMapper.map(user, UserDto.class));
            }
            return new ResponseEntity<>(usersDTOLike, HttpStatus.ACCEPTED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/createdAtAfter/{startDate}")
    public ResponseEntity<List<UserDto>> findUsersCreatedAfter(@PathVariable String startDate){

        try{
            ModelMapper modelMapper = new ModelMapper();
            List<User> users = userService.findUsersCreatedAfter(startDate);
            List<UserDto> usersDTOCreatedAfter = new ArrayList<>();
            for (User user : users) {
                usersDTOCreatedAfter.add(modelMapper.map(user, UserDto.class));
            }
            return new ResponseEntity<>(usersDTOCreatedAfter, HttpStatus.ACCEPTED);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }


}


}
