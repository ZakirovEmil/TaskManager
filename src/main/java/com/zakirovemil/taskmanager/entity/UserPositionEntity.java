package com.zakirovemil.taskmanager.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users_positions")
public class UserPositionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private PositionEntity position;

    public UserPositionEntity() {
    }

    public UserPositionEntity(UserEntity user, PositionEntity position) {
        this.user = user;
        this.position = position;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public PositionEntity getPosition() {
        return position;
    }

    public void setPosition(PositionEntity position) {
        this.position = position;
    }

}
