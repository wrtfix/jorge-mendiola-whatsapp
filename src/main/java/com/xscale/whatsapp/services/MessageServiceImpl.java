package com.xscale.whatsapp.services;

import com.xscale.whatsapp.entities.Message;
import com.xscale.whatsapp.entities.User;
import com.xscale.whatsapp.repository.GroupRepository;
import com.xscale.whatsapp.repository.MessageRepository;
import com.xscale.whatsapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Jorge Carlos Mendiola
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * This method has to notify all users that are in the group.
     * In this case I will log the messages that the users recibe.
     * TODO: I should implement a WebSocket to notify all users that are connected to a particular group.
     * @param message
     * @return
     */
    public Message saveMessage(Message message){
        Message newMessages = messageRepository.save(message);
        User fromUser = userRepository.findById(message.getUser().getId()).get();
        groupRepository.findById(newMessages.getGroup().getId())
                .get()
                .getUsers()
                .parallelStream()
                .forEach( user -> {
                    if (message.getUser().getId() != user.getId()) {
                        user.notifyMessage(fromUser.getNickName(),message);
                    }
                });

        return messageRepository.save(message);
    }

    /**
     *
     * @param id
     */
    public void deleteMessage(long id){
        messageRepository.deleteById(id);
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Message> getMessage(long id){
        return messageRepository.findById(id);
    }

    /**
     *
     * @return
     */
    public List<Message> getMessages(){
        return messageRepository.findAll();
    }

    /**
     *
     * @param message
     * @return
     */
    public Message updateMessage(Message message){
        Message messageUpdate = getMessage(message.getId()).get();
        messageUpdate.setMessage(message.getMessage());
        messageUpdate.setGroup(message.getGroup());
        messageUpdate.setUser(message.getUser());
        return messageRepository.save(messageUpdate);

    }
}
