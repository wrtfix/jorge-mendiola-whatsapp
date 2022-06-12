package com.xscale.whatsapp.repository;

import com.xscale.whatsapp.entities.Group;
import com.xscale.whatsapp.entities.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author Jorge Carlos Mendiola
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestUserRepository {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    public void saveUser(){
        User user = User.builder().nickName("Jorge").id(1).build();
        userRepository.save(user);
    }

    @Test
    @Order(2)
    public void removeUser(){
        userRepository.deleteById(1l);
    }

    @Test
    @Order(3)
    public void updateUser(){
        User user = User.builder().nickName("Jose").id(1).build();
        userRepository.save(user);
    }

    @Test
    @Order(4)
    public void getUser(){
        User user = userRepository.findById(1l).get();
        assertEquals("Jose", user.getNickName());
    }

    @Test
    @Order(5)
    public void saveUserGroup(){
        List<Group> groups =  new ArrayList<>();
        groups.add(Group.builder().id(1).name("Tecnologia").build());
        User user = User.builder().nickName("Jorge").id(1).groups(groups).build();
        userRepository.save(user);
    }

    @Test
    @Order(6)
    public void saveUserContact(){
        List<User> users =  new ArrayList<>();
        User newUser = User.builder().id(3).nickName("Carlos").build();
        users.add(newUser);
        userRepository.save(newUser);
        User user = User.builder().nickName("Jorge").id(1).contracts(users).build();
        userRepository.save(user);
    }



}
