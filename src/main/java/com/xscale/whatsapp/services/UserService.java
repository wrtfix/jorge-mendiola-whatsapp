package com.xscale.whatsapp.services;

import com.xscale.whatsapp.entities.User;

import java.util.List;
import java.util.Optional;
/**
 * @author Jorge Carlos Mendiola
 */
public interface UserService {
    User saveUser(User user);
    void deleteUser(long id);
    Optional<User> getUser(long id);
    List<User> getUsers();
    User updateUser(User user);

}
