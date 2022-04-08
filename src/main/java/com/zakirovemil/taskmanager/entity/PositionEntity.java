package com.zakirovemil.taskmanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "positions")
public class PositionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "position_name")
    private String positionName;

    public PositionEntity() {
    }

    public PositionEntity(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
