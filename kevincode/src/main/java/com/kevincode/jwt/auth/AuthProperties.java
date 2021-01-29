package com.kevincode.jwt.auth;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * User: kevin.xie<br/>
 * Date: 24/10/2020<br/>
 * Time: 15:02<br/>
 */
@Data
@Component
@ConfigurationProperties( prefix = "cognito")
public class AuthProperties {

    public String clientId;

    public String secretId;

    public String callbackUrl;

    public String keys;

    public String endpointAuthorize;

    public String endpointToken;

    public String urls;

}
