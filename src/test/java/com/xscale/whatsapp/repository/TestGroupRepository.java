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
public class TestGroupRepository {
    @Autowired
    private GroupRepository groupRepository;

    @Test
    @Order(1)
    public void saveGroup(){
        Group group = Group.builder().id(1).name("Tecnologia").build();
        groupRepository.save(group);
    }

    @Test
    @Order(2)
    public void removeGroup(){
        groupRepository.deleteById(1l);
    }

    @Test
    @Order(3)
    public void updateGroup(){
        Group group = Group.builder().id(1).name("Informacion").build();
        groupRepository.save(group);
    }

    @Test
    @Order(4)
    public void getGroup(){
        Group group = groupRepository.findById(1l).get();
        assertEquals("Informacion", group.getName());
    }

    @Test
    @Order(5)
    public void saveGroupUser(){
        Group group = Group.builder().id(1).name("Tecnologia").build();
        List<User> users = new ArrayList<>();
        users.add(User.builder().nickName("Jose").id(2).build());
        groupRepository.save(group);
    }



}
