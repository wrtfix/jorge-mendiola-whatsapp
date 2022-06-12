package com.xscale.whatsapp.repository;

import com.xscale.whatsapp.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Jorge Carlos Mendiola
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}
