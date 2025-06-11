package br.com.fiap.challenge.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private final String segredo = "minhaChaveSecreta123456"; // deve ter um bom tamanho
    private final Algorithm algoritmo = Algorithm.HMAC256(segredo);

    public String gerarToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 86400000)) // 1 dia
                .sign(algoritmo);
    }

    public String extrairUsername(String token) {
        DecodedJWT decodedJWT = JWT.require(algoritmo)
                .build()
                .verify(token);
        return decodedJWT.getSubject();
    }

    public boolean validarToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(algoritmo).build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
