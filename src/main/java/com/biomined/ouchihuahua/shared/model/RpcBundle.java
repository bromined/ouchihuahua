package com.biomined.ouchihuahua.shared.model;

/**
 * Created by IntelliJ IDEA.
 * User: stephencole
 * Date: 7/22/13
 * Time: 3:46 PM
 */
public class RpcBundle {

    private AuthDTO authDTO;
    private PainEventDTO painEventDTO;

    public RpcBundle(AuthDTO authDTO, PainEventDTO painEventDTO) {
        this.authDTO = authDTO;
        this.painEventDTO = painEventDTO;
    }

    public AuthDTO getAuthDTO() {
        return authDTO;
    }

    public PainEventDTO getPainEventDTO() {
        return painEventDTO;
    }
}
