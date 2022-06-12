package com.xscale.whatsapp.services;

import com.xscale.whatsapp.entities.Group;

import java.util.List;
import java.util.Optional;
/**
 * @author Jorge Carlos Mendiola
 */
public interface GroupService {
    Group saveGroup(Group group);
    void deleteGroup(long id);
    Optional<Group> getGroup(long id);
    List<Group> getGroups();
    Group updateGroup(Group group);
}
