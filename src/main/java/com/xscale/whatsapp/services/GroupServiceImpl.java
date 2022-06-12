package com.xscale.whatsapp.services;

import com.xscale.whatsapp.entities.Group;
import com.xscale.whatsapp.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Jorge Carlos Mendiola
 */
@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupRepository groupRepository;

    /**
     *
     * @param group
     * @return
     */
    public Group saveGroup(Group group){
        return groupRepository.save(group);
    }

    /**
     *
     * @param id
     */
    public void deleteGroup(long id){
        groupRepository.deleteById(id);
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Group> getGroup(long id){
        return groupRepository.findById(id);

    }

    /**
     *
     * @return
     */
    public List<Group> getGroups(){
        return groupRepository.findAll();
    }

    /**
     * @param group
     * @return
     */
    @Override
    public Group updateGroup(Group group) {
        Group groupUpdate = getGroup(group.getId()).get();
        groupUpdate.setName(group.getName());
        groupUpdate.setUsers(group.getUsers());
        return groupRepository.save(groupUpdate);
    }


}
