package com.xscale.whatsapp.services;

import com.xscale.whatsapp.entities.Message;

import java.util.List;
import java.util.Optional;
/**
 * @author Jorge Carlos Mendiola
 */
public interface MessageService {
    Message saveMessage(Message message);
    void deleteMessage(long id);
    Optional<Message> getMessage(long id);
    List<Message> getMessages();
    Message updateMessage(Message message);
}
