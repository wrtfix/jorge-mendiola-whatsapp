package com.xscale.whatsapp.services;

import com.xscale.whatsapp.entities.User;
import com.xscale.whatsapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

/**
 * @author Jorge Carlos Mendiola
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    /**
     * @param user
     * @return
     */
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * @param id
     */
    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<User> getUser(long id) {
        return userRepository.findById(id);
    }

    /**
     * @return
     */
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /**
     * @param user
     * @return
     */
    @Override
    public User updateUser(User user) {
        User updateUser = getUser(user.getId()).get();
        updateUser.setGroups(user.getGroups());
        updateUser.setNickName(user.getNickName());
        updateUser.setNumber(user.getNumber());
        updateUser.setContracts(user.getContracts());
        return userRepository.save(updateUser);
    }
}
