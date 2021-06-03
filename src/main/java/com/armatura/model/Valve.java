package com.armatura.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="valves")
public class Valve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "biu")
    private String biu;

    @Column(name = "name")
    private String name;

    @Column(name = "assembly")
    private String assembly;

    @Column(name = "locker")
    private String locker;

    @Column(name = "position")
    private String position;

    @Column(name = "location")
    private String location;
}
