package com.wallacecarlos.Usuario.business;

import com.wallacecarlos.Usuario.business.converter.UsuarioConverter;
import com.wallacecarlos.Usuario.business.dto.UsuarioDTO;
import com.wallacecarlos.Usuario.infrastructure.entity.Usuario;
import com.wallacecarlos.Usuario.infrastructure.execptions.ConflictExecption;
import com.wallacecarlos.Usuario.infrastructure.execptions.ResourceNotFoundExecption;
import com.wallacecarlos.Usuario.infrastructure.repository.UsuarioRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Builder

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;
    private final PasswordEncoder passwordEncoder;

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        emailExite(usuarioDTO.getEmail());
        usuarioDTO.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));

        Usuario usuario = usuarioConverter.paraUSuario(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return usuarioConverter.paraUSuarioDTO
                (usuario = usuarioRepository.save(usuario));

    }

    public void emailExite(String email) {
        try {
            boolean exite = VerificaEmailExistente(email);
            if (exite) {
                throw new ConflictExecption("Email ja cadstrado" + email);
            }
        } catch (ConflictExecption e) {
            throw new ConflictExecption("Email ja cadastrado" + e.getCause());

        }
    }

    public boolean VerificaEmailExistente(String email) {
        return usuarioRepository.existsByEmail(email);

    }

    public Usuario buscarUsuarioPoremail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundExecption("email não encotrado" + email));
    }

    public void deletarUsuarioPorEmail(String email) {
        usuarioRepository.deleteByEmail(email);

    }
}






