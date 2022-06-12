package com.xscale.whatsapp.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;
/**
 * @author Jorge Carlos Mendiola
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "GROUPS")
public class Group {
    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
    private String name;
    @OneToMany
    private List<User> users;
}
