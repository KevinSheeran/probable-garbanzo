//package com.mcpayment.payx.api.jwt;
//
//import com.mcpayment.payx.api.jwt.auth.AuthProperties;
//import com.nimbusds.jose.JWSAlgorithm;
//import com.nimbusds.jose.jwk.source.JWKSource;
//import com.nimbusds.jose.jwk.source.RemoteJWKSet;
//import com.nimbusds.jose.proc.JWSVerificationKeySelector;
//import com.nimbusds.jose.proc.SecurityContext;
//import com.nimbusds.jose.util.DefaultResourceRetriever;
//import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
//import com.nimbusds.jwt.proc.DefaultJWTProcessor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
///**
// * User: kevin.xie<br/>
// * Date: 23/10/2020<br/>
// * Time: 13:40<br/>
// */
//@Configuration
//public class JwtProcessor {
//
//    @Autowired
//    AuthProperties authProperties;
//
//    @Bean
//    public ConfigurableJWTProcessor<SecurityContext> configurableJWTProcessor() throws MalformedURLException {
//        DefaultResourceRetriever resourceRetriever = new DefaultResourceRetriever(5000, 5000);
//        URL jwtSetUrl = new URL(authProperties.urls);
//        JWKSource<SecurityContext> keySource = new RemoteJWKSet(jwtSetUrl, resourceRetriever);
//        ConfigurableJWTProcessor<SecurityContext> jwtProcessor = new DefaultJWTProcessor();
//        JWSVerificationKeySelector<SecurityContext> keySelector = new JWSVerificationKeySelector(JWSAlgorithm.RS256, keySource);
//        jwtProcessor.setJWSKeySelector(keySelector);
//        return jwtProcessor;
//    }
//
//
//}
