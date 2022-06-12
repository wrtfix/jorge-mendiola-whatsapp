package com.xscale.whatsapp.repository;

import com.xscale.whatsapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Jorge Carlos Mendiola
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
