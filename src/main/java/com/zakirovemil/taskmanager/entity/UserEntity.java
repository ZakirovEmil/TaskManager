package com.zakirovemil.taskmanager.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "user")
    private UserPositionEntity userPositionEntity;

    @OneToMany(mappedBy = "user")
    private List<TaskEntity> taskEntities;

    public UserEntity() {
    }

    public UserEntity(String login, String password, UserPositionEntity userPositionEntity, List<TaskEntity> taskEntities) {
        this.login = login;
        this.password = password;
        this.userPositionEntity = userPositionEntity;
        this.taskEntities = taskEntities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserPositionEntity getUserPositionEntity() {
        return userPositionEntity;
    }

    public void setUserPositionEntity(UserPositionEntity userPositionEntity) {
        this.userPositionEntity = userPositionEntity;
    }

    public List<TaskEntity> getTaskEntities() {
        return taskEntities;
    }

    public void setTaskEntities(List<TaskEntity> taskEntities) {
        this.taskEntities = taskEntities;
    }
}
