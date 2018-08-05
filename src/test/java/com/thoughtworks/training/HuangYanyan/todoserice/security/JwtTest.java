package com.thoughtworks.training.HuangYanyan.todoserice.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class JwtTest {
    @Test
    public void generateJwt(){
        HashMap<String,Object> claims = new HashMap<>();

        claims.put("name","xiaohong");
        claims.put("role","dev");

        //Generate
        String token = Jwts.builder().addClaims(claims).
                setExpiration(Date.from(Instant.now().plus(100,ChronoUnit.DAYS))).signWith(SignatureAlgorithm.HS512,"kitty".getBytes()).compact();


        //Parse & Verification
        byte[] secretKey = "kitty".getBytes();

        Claims body =Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        assertThat(body.get("name"),is("xiaohong"));
        assertThat(body.get("role"),is("dev"));

    }
}
