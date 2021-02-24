package com.example.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.dao.UserMapper;
import com.example.pojo.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Map;

/**
 * @author : lqy
 * @Date : 2021/2/24 16:33
 */
public class JwtUtil {
    public static final String PRIVATE_KEY = "abc";
    public static final String AUDIENCE = "accenture";

    public static String createToken(Integer id) {
        return JWT.create().withAudience(AUDIENCE).withIssuedAt(new Date()).withKeyId(id.toString()).sign(Algorithm.HMAC256(PRIVATE_KEY));
    }

    public static boolean verifyToken(String token, String secret) {
        DecodedJWT jwt = null;
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret + PRIVATE_KEY)).build();
        jwt = jwtVerifier.verify(token);
        if (!jwt.getAudience().equals(AUDIENCE)
                || !jwt.getKeyId().equals(secret)
                || !jwt.getSignature().equals(PRIVATE_KEY)) {
            return false;
        }
        return true;

    }

}
