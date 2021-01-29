//package com.mcpayment.payx.api.handler;
//
//import com.nimbusds.jose.proc.SecurityContext;
//import com.nimbusds.jwt.JWTClaimsSet;
//import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
//import io.jsonwebtoken.*;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//import static java.util.List.of;
//
//
///**
// * User: kevin.xie<br/>
// * Date: 14/10/2020<br/>
// * Time: 10:07<br/>
// */
//@Log4j2
//@Component
//public class AuthFilter extends OncePerRequestFilter {
//
//    @Autowired
//    AuthProperties authProperties;
//
//    @Autowired
//    ConfigurableJWTProcessor<SecurityContext> contextConfigurableJWTProcessor;
//
//    public AuthFilter(ConfigurableJWTProcessor<SecurityContext> contextConfigurableJWTProcessor) {
//        this.contextConfigurableJWTProcessor = contextConfigurableJWTProcessor;
//    }
//
//    private CognitoAuthenticationToken extractAuthentication(String token) {
//        try {
//            JWTClaimsSet claim = contextConfigurableJWTProcessor.process(token, null);
//
//            return new CognitoAuthenticationToken(token, claim, of());
//        } catch (Exception e) {
//            throw new AccessDeniedException("No message ", e);
//        }
//
//    }
//
//    private String extractToken(HttpServletRequest req) {
//        String header = req.getHeader(HttpHeaders.AUTHORIZATION);
//        if (!StringUtils.isEmpty(header)) {
//            String[] headers = header.split("Bearer");
//            log.debug("jwtToken:{}", headers[1]);
//            return headers[1];
//        } else {
//            return null;
//        }
//
//    }
//
//    @Override
//    public void doFilterInternal(HttpServletRequest req,
//                         HttpServletResponse resp,
//                         FilterChain chain) throws IOException, ServletException {
//        try{
//
//            String token = extractToken(req);
//            if (token != null && validateToken(token) ) {
//
//                CognitoAuthenticationToken authentication = extractAuthentication(token);
//
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//
//        } catch (AccessDeniedException e) {
//            SecurityContextHolder.clearContext();
//            log.error("Cognito ID Token processing error", e);
//            throw new AccessDeniedException("Access Denied");
//        }
//
//        chain.doFilter(req, resp);
//
//    }
//
//    private boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(authProperties.secretId).parseClaimsJws(token);
//            return true;
//        } catch (SignatureException e) {
//            log.error("Invalid JWT signature: {}", e.getMessage());
//        } catch (MalformedJwtException e) {
//            log.error("Invalid JWT token: {}", e.getMessage());
//        } catch (ExpiredJwtException e) {
//            log.error("JWT token is expired: {}", e.getMessage());
//        } catch (UnsupportedJwtException e) {
//            log.error("JWT token is unsupported: {}", e.getMessage());
//        } catch (IllegalArgumentException e) {
//            log.error("JWT claims string is empty: {}", e.getMessage());
//        }
//        return false;
//    }
//
//}
