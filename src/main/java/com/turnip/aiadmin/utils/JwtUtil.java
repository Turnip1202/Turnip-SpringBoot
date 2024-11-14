package com.turnip.aiadmin.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class JwtUtil {
    public static final String SECRET = "secret";
    public  static String createToken(String id, String name, Map<String,Object> map){
       // System.out.println("test");
        JwtBuilder jwtBuilder = Jwts.builder()
                                            .setId(id).setSubject(name).setIssuedAt(new Date())
                                            .signWith(SignatureAlgorithm.HS256, SECRET)
                                            .claim("testMsg","测试token");jwtBuilder.setExpiration(new Date(System.currentTimeMillis()+60*60*1000));//过期时间为一小时
        jwtBuilder.setClaims(map);
        var token = jwtBuilder.compact();
     //   System.out.println("token---:"+token);
        return token;
    }
}
