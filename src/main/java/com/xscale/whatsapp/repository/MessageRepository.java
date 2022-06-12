package com.xscale.whatsapp.repository;

import com.xscale.whatsapp.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Jorge Carlos Mendiola
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
