package com.xscale.whatsapp.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

/**
 * @author Jorge Carlos Mendiola
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "USERS")
@Slf4j
public class User {
    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
    private String nickName;
    private String number;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Group> groups;
    @OneToMany(fetch = FetchType.LAZY)
    private List<User> contracts;

    public void notifyMessage(String from,Message message){
        log.info("{}: {}", from, message.getMessage());
    }
}
