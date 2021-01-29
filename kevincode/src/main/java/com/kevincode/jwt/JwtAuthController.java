package com.mcpayment.payx.api.jwt;

import com.mcpayment.payx.api.jwt.model.TokenClaims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: kevin.xie<br/>
 * Date: 24/10/2020<br/>
 * Time: 11:16<br/>
 */
@RestController
@RequestMapping("/user")
public class JwtAuthController {

    @Autowired
    AuthService authService;

    @GetMapping("/me")
    public TokenClaims getMe() {
        return authService.getClaims();
    }

}
