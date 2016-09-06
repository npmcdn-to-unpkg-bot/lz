package sk.liptovzije.service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import sk.liptovzije.model.AuthResponse;
import sk.liptovzije.model.User;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * Created by jan.husenica on 8/29/2016.
 */
@Component
public class AuthenticatorImpl implements  IAuthenticator{

    private static final String issuer = "http://liptovzije.sk";
    private static final String secret = "mySecret";
    private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    public AuthResponse sign(User user) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        JwtBuilder builder = Jwts.builder().setId(Long.toString(user.getId()))
                .setIssuedAt(now)
                .setIssuer(issuer)
                .setSubject(user.getCredentials().getUsername())
                .signWith(signatureAlgorithm, signingKey);

        return new AuthResponse(builder.compact());
    }

    public void verify(String token) {

    }

    public void validate(String token) {

    }
}
