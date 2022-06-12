package com.xscale.whatsapp.controller;

import com.xscale.whatsapp.entities.User;
import com.xscale.whatsapp.services.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

import static org.springframework.http.HttpStatus.ACCEPTED;
/**
 * @author Jorge Carlos Mendiola
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    private static final String NO_FOUND = "Its not possible to do this operation";

    @PostMapping(value="/addUser")
    public ResponseEntity saveUser(@RequestBody User user) throws Exception {
        return userService.saveUser(user) != null ? new ResponseEntity(ACCEPTED, ACCEPTED) : new ResponseEntity(NO_FOUND,HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/allUser")
    public ResponseEntity getAllUser() throws Exception {
        return new ResponseEntity(userService.getUsers(), ACCEPTED);
    }

    @PutMapping(value="/updateUser")
    public ResponseEntity updateUser(@RequestBody User user) throws Exception {
        return userService.updateUser(user) != null ? new ResponseEntity(ACCEPTED, ACCEPTED) : new ResponseEntity(NO_FOUND,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value="/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathParam("id") long id) throws Exception {
        userService.deleteUser(id);
        log.info("deleteUser {}", id);
        return new ResponseEntity(ACCEPTED, ACCEPTED);
    }
}
