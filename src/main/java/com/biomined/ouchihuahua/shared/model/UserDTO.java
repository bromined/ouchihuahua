package com.biomined.ouchihuahua.shared.model;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/18/13
 * Time: 4:34 PM
 */
public class UserDTO implements IsSerializable {

    private Long id;
    private String username;
    private String passwordHash;
    private String email;

    public UserDTO(User user) {
        if (user.getId() != null) {
            this.id = user.getId();
        }

        if (user.getUsername() != null) {
            this.username = user.getUsername();
        }

        if (user.getPasswordHash() != null) {
            this.passwordHash = user.getPasswordHash();
        }

        if (user.getEmail() != null) {
            this.email = user.getEmail();
        }
    }

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
