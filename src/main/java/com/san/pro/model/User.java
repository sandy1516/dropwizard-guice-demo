/**
 * Created by Sandeep Singh on 03-10-2015.
 */

package com.san.pro.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

    @Id
    @NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", precision=0)
    private long id;

    @NotNull
    @Size(min = 2, max = 64)
    private String name;

    @NotNull
    @Size(min = 2, max = 16)
    private String login;

    @NotNull
    @Size(min = 2, max = 16)
    private String password;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String toString() {
        return " name " +getName()+" login "+getLogin()+ " password "+getPassword();
    }
}
