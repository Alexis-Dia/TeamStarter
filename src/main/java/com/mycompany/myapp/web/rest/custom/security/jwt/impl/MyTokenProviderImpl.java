package com.mycompany.myapp.web.rest.custom.security.jwt.impl;

import com.mycompany.myapp.web.rest.custom.modulePojo.TokenPojo;
import com.mycompany.myapp.web.rest.custom.security.jwt.MyTokenProvider;
import io.jsonwebtoken.*;
import jdk.nashorn.internal.parser.Token;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyTokenProviderImpl implements MyTokenProvider {

    @Override
    public TokenPojo createToken(String id, String userName) {
        String secretKey = "Alex";

        String jwt = Jwts.builder().
            setId(id).
            setSubject(userName).
            signWith(SignatureAlgorithm.HS256, secretKey).
            compact();

        TokenPojo tokenPojo = new TokenPojo(jwt);

        return tokenPojo;
    }
}
