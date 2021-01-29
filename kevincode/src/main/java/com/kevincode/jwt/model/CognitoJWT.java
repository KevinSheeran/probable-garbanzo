package com.mcpayment.payx.api.jwt.model;

import lombok.Data;

/**
 * User: kevin.xie<br/>
 * Date: 23/10/2020<br/>
 * Time: 15:00<br/>
 */
@Data
public class CognitoJWT {

    public String idToken;
    public String accessToken;
    public String refreshToken;
    public Integer expiresIn;
    public String tokenType;
}
