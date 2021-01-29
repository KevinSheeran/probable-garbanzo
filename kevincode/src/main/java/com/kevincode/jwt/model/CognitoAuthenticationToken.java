
import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * User: kevin.xie<br/>
 * Date: 23/10/2020<br/>
 * Time: 14:11<br/>
 */
public class CognitoAuthenticationToken extends AbstractAuthenticationToken {

    public String token;

    public JWTClaimsSet details;

    public CognitoAuthenticationToken(String token, JWTClaimsSet jwtClaimSet, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.token = token;
        this.details = jwtClaimSet;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return details;
    }

}
