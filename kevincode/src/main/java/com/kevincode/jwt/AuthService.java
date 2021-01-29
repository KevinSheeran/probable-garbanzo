//package com.mcpayment.payx.api.jwt;
//
//import com.mcpayment.payx.api.jwt.auth.AuthProperties;
//import com.mcpayment.payx.api.jwt.model.CognitoJWT;
//import com.mcpayment.payx.api.jwt.model.TokenClaims;
//import com.nimbusds.jwt.JWTClaimsSet;
//import kong.unirest.ContentType;
//import kong.unirest.HeaderNames;
//import kong.unirest.HttpResponse;
//import kong.unirest.Unirest;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
///**
// * User: kevin.xie<br/>
// * Date: 26/10/2020<br/>
// * Time: 15:32<br/>
// */
//@Service
//@Log4j2
//public class AuthService {
//
//    @Autowired
//    AuthProperties authProperties;
//
//    public TokenClaims getClaims() {
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        JWTClaimsSet jwtClaimsSet = (JWTClaimsSet)authentication.getDetails();
//        TokenClaims tokenClaims = new TokenClaims();
//        tokenClaims.uuid = (String)jwtClaimsSet.getClaim("sub");
//        tokenClaims.authTime = (Long) jwtClaimsSet.getClaim("auth_time");
//        tokenClaims.issued = (Date)jwtClaimsSet.getClaim("iat");
//        tokenClaims.expire = (Date)jwtClaimsSet.getClaim("exp");
//        tokenClaims.name = (String)jwtClaimsSet.getClaim("name");
//        tokenClaims.cognitoUsername = (String)jwtClaimsSet.getClaim("cognito:username");
//        tokenClaims.email = (String)jwtClaimsSet.getClaim("email");
//
//        return tokenClaims;
//    }
//
//    public CognitoJWT getToken(String code) {
//        CognitoJWT cognitoJWT = new CognitoJWT();
//
//        HttpResponse<byte[]> httpResponse = Unirest.post(authProperties.endpointToken
//                + "?grant_type=authorization_code&client_id=" +
//                authProperties.clientId + "&code=" + code + "&redirect_url=" + authProperties.callbackUrl)
//                .header(HeaderNames.CONTENT_TYPE, ContentType.APPLICATION_FORM_URLENCODED.getMimeType())
//                .header(HeaderNames.AUTHORIZATION, "Bearer ")
//                .header("HeaderName", "value")
//                .asBytes();
//        byte[] body = httpResponse.getBody();
//
//        return cognitoJWT;
//
//    }
//
//}
