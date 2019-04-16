package com.example.chat.database.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "Direction")
@Data
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User from;

    @ManyToOne(fetch = FetchType.EAGER)
    private User toUser;

    @OneToMany(mappedBy = "direction",cascade = CascadeType.ALL)
    private List<ChatData> chatData = new LinkedList<>();
}
