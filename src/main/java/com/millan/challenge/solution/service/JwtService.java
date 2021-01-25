package com.millan.challenge.solution.service;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Date;
import static java.time.ZoneOffset.UTC;

@Component
public class JwtService {

    private static final String ISSUER = "com.millan.challenge";
    private static final String SAMPLE_SECRET = "mysecret";

    public String generateToken(String username) throws IOException, URISyntaxException {
        byte[] secretKey = SAMPLE_SECRET.getBytes();
        Date expiration = Date.from(LocalDateTime.now(UTC).plusHours(2).toInstant(UTC));

          JwtBuilder  jb = Jwts.builder()
                .setSubject(username)
                .setExpiration(expiration)
                .setIssuer(ISSUER)
                .signWith(SignatureAlgorithm.HS512, secretKey);

        return jb.compact();
    }

    public String verifyToken(String token) throws IOException, URISyntaxException {
        byte[] secretKey = SAMPLE_SECRET.getBytes();
        Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
        //returning authenticated/verified username
        return claims.getBody().getSubject();
    }

}
