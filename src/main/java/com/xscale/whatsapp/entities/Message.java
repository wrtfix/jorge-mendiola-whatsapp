package com.xscale.whatsapp.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;
/**
 * @author Jorge Carlos Mendiola
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "MESSAGES")
public class Message {
    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
    private String message;
    private Date creationDate;
    @OneToOne
    private User user;
    @OneToOne
    private Group group;
}
