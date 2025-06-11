package br.com.fiap.challenge.service;

import br.com.fiap.challenge.DTO.UsuarioDTO;
import br.com.fiap.challenge.model.Usuario;
import br.com.fiap.challenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return User.builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha()) // Senha já criptografada!
                .roles(usuario.getRole())
                .build();
    }

    public Usuario cadastrar(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setLogin(dto.login());
        usuario.setSenha(passwordEncoder.encode(dto.senha()));
        usuario.setRole(dto.role() != null ? dto.role() : "USER");

        return usuarioRepository.save(usuario);
    }
}
