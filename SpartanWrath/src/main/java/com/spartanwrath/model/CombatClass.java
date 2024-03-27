package com.spartanwrath.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombatClass {
    private Long id;
    private String name;
    private String description;
    private String turn;
    private List<Membership> memberships;

    public CombatClass() {
    }

    public CombatClass(Long id, String name, String description, String turn) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.turn = turn;
        this.memberships = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTurn() {
        return turn;
    }

    public List<Membership> getMemberships() {
        return memberships;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public void setMemberships(List<Membership> memberships) {
        this.memberships = memberships;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", turn=" + turn +
                ", memberships=" + memberships +
                '}';
    }
}
