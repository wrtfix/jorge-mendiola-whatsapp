package com.xscale.whatsapp.controller;

import com.xscale.whatsapp.entities.Group;
import com.xscale.whatsapp.services.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.ACCEPTED;
/**
 * @author Jorge Carlos Mendiola
 */
@RestController
public class GroupController {

    @Autowired
    private GroupServiceImpl groupService;

    private static final String NO_FOUND = "Its not possible to do this operation";

    @PostMapping(value="/addGroup")
    public ResponseEntity saveGroup(@RequestBody Group group) throws Exception {
        return groupService.saveGroup(group) != null ? new ResponseEntity(ACCEPTED, ACCEPTED) : new ResponseEntity(NO_FOUND,HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/allGroup")
    public ResponseEntity getAllGroup() throws Exception {
        return new ResponseEntity(groupService.getGroups(), ACCEPTED);
    }

    @PutMapping(value="/updateGroup")
    public ResponseEntity updateGroup(@RequestBody Group group) throws Exception {
        return groupService.updateGroup(group) != null ? new ResponseEntity(ACCEPTED, ACCEPTED) : new ResponseEntity(NO_FOUND,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value="/deleteGroup")
    public ResponseEntity deleteGroup(@RequestBody long id) throws Exception {
        groupService.deleteGroup(id);
        return new ResponseEntity(ACCEPTED, ACCEPTED);
    }
}
