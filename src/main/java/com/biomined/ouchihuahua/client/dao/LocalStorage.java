package com.biomined.ouchihuahua.client.dao;

import com.google.gwt.storage.client.Storage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 6/21/13
 * Time: 3:23 PM
 */
public class LocalStorage {

    public static void putUser(String username, String password) {

        Storage localStorage = Storage.getLocalStorageIfSupported();
        if (localStorage != null) {
            localStorage.setItem("paintrackerUsername", username);
            localStorage.setItem("paintrackerPassword", password);
        }
    }

    public static Map<String, String> fetchUser() {

        Map<String, String> userMap = new HashMap<String, String>();

        Storage localStorage = Storage.getLocalStorageIfSupported();
        if (localStorage != null) {

            String username = localStorage.getItem("paintrackerUsername");
            String password = localStorage.getItem("paintrackerPassword");

            if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
                userMap.put("username", username);
                userMap.put("passwordHash", password);
                return userMap;
            }
        }

        return null;
    }
}
