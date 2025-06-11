package br.com.fiap.challenge.controller;

import br.com.fiap.challenge.DTO.LoginDTO;
import br.com.fiap.challenge.DTO.UsuarioDTO;
import br.com.fiap.challenge.model.Usuario;
import br.com.fiap.challenge.service.AuthService;
import br.com.fiap.challenge.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private AuthService authService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO login) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(login.login(), login.senha());

        authManager.authenticate(authToken);

        String token = jwtUtils.gerarToken(login.login());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/signup")
    public ResponseEntity<Usuario> registrar(@RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(authService.cadastrar(dto));
    }
}

