package com.zakirovemil.taskmanager.model;

import com.zakirovemil.taskmanager.entity.UserEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserModel {

    private long id;
    private String login;

    public UserModel(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.login = userEntity.getLogin();
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
}
