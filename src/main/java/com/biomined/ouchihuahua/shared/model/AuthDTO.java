package com.biomined.ouchihuahua.shared.model;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/22/13
 * Time: 3:07 PM
 */
public class AuthDTO implements IsSerializable {

    private Long id;
    private String username;
    private String passwordHash;

    public AuthDTO(Long id, String username, String passwordHash) {

        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public AuthDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
