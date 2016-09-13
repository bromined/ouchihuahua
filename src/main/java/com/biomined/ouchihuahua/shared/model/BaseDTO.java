package com.biomined.ouchihuahua.shared.model;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/22/13
 * Time: 12:02 PM
 */
public class BaseDTO implements IsSerializable {

    private Long userId;
    private String username;
    private String passwordHash;
    private String message;

    public BaseDTO(Long userId, String username, String passwordHash) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public BaseDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    private String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String consumeMessage() {

        String temp = getMessage();
        this.message = null;

        return temp;
    }
}
