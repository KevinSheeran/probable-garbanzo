package com.mcpayment.payx.api.jwt.model;

import lombok.Data;

import java.util.Date;

/**
 * User: kevin.xie<br/>
 * Date: 23/10/2020<br/>
 * Time: 15:24<br/>
 */
@Data
public class TokenClaims {
    public String uuid;
    public Long authTime;
    public Date issued;
    public Date expire;
    public String name;
    public String cognitoUsername;
    public String email;
}
