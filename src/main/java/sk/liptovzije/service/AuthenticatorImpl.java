package sk.liptovzije.service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;
import sk.liptovzije.model.AuthResponse;
import sk.liptovzije.model.User;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * Created by jan.husenica on 8/29/2016.
 */
@Component
public class AuthenticatorImpl implements  IAuthenticator{

    private static final String ISSUER = "http://liptovzije.sk";
    private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    private static final String secret = "H7PP2i+cxNQrDQOxq7KhhKuQX9HkvbsVpzrwMzyLRAQ=";

    public static final String SIGN = "Bearer";

//    tvorba kluca
//    SecretKey key = MacProvider.generateKey(SignatureAlgorithm.HS256);
//    String base64Encoded = TextCodec.BASE64.encode(key.getEncoded());

    public AuthResponse sign(User user){
        long nowMillis = System.currentTimeMillis();
        byte[] key = TextCodec.BASE64.decode(secret);
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder().setId(Long.toString(user.getId()))
                .setIssuedAt(now)
                .setIssuer(ISSUER)
                .setSubject(user.getCredentials().getUsername())
                .signWith(signatureAlgorithm, key);

        return new AuthResponse(builder.compact());
    }

    public boolean verify(String authHeader) {
        if(authHeader == null || (authHeader != null && authHeader.length() > SIGN.length())) {
            return false;
        }

        String token = authHeader.substring(SIGN.length() + 1);
//TODO: dokoncit logiku
        return true;
    }
}
