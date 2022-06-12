package com.xscale.whatsapp.controller;

import com.xscale.whatsapp.entities.Message;
import com.xscale.whatsapp.entities.User;
import com.xscale.whatsapp.services.MessageServiceImpl;
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
public class MessageController {

    @Autowired
    private MessageServiceImpl messageService;

    private static final String NO_FOUND = "Its not possible to do this operation";

    @PostMapping(value="/addMessage")
    public ResponseEntity saveMessage(@RequestBody Message message) throws Exception {
        return messageService.saveMessage(message) != null ? new ResponseEntity(ACCEPTED, ACCEPTED) : new ResponseEntity(NO_FOUND,HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/allMessage")
    public ResponseEntity getAllMessage() throws Exception {
        return new ResponseEntity(messageService.getMessages(), ACCEPTED);
    }

    @PutMapping(value="/updateMessage")
    public ResponseEntity updateMessage(@RequestBody Message message) throws Exception {
        return messageService.updateMessage(message) != null ? new ResponseEntity(ACCEPTED, ACCEPTED) : new ResponseEntity(NO_FOUND,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value="/deleteMessage/{id}")
    public ResponseEntity deleteMessage(@PathParam("id") long id) throws Exception {
        messageService.deleteMessage(id);
        return new ResponseEntity(ACCEPTED, ACCEPTED);
    }
}
