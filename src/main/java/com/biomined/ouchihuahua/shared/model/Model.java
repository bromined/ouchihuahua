package com.biomined.ouchihuahua.shared.model;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 5/1/13
 * Time: 4:47 PM
 */
public class Model implements IsSerializable {

    private UserDTO userDTO;

    public Model() {

    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
