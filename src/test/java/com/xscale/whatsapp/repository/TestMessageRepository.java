package com.xscale.whatsapp.repository;

import com.xscale.whatsapp.entities.Group;
import com.xscale.whatsapp.entities.Message;
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
public class TestMessageRepository {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;

    @Test
    @Order(1)
    public void saveMessage(){
        Message message = Message.builder().id(1).message("test").build();
        messageRepository.save(message);
    }

    @Test
    @Order(2)
    public void removeMessage(){
        messageRepository.deleteById(1l);
    }

    @Test
    @Order(3)
    public void updateMessage(){
        Message message = Message.builder().id(1).message("test 2").build();
        messageRepository.save(message);
    }

    @Test
    @Order(4)
    public void getMessage(){
        Message message = messageRepository.findById(1l).get();
        assertEquals("test 2", message.getMessage());
    }

    @Test
    @Order(5)
    public void saveMessageUserGroup(){
        Group group =  Group.builder().id(2).name("Comunicacion").build();
        List<User> users = new ArrayList<>();
        User user = User.builder().nickName("Pedro").id(2).build();
        users.add(user);
        groupRepository.save(group);

        List<Group> groups =  new ArrayList<>();
        groups.add(group);
        user.setGroups(groups);
        userRepository.save(user);


        Message message = Message.builder().id(1).message("test 2").user(user).group(group).build();
        messageRepository.save(message);
    }

}
