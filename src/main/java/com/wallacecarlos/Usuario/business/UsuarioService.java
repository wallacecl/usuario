package com.wallacecarlos.Usuario.business;

import com.wallacecarlos.Usuario.business.converter.UsuarioConverter;
import com.wallacecarlos.Usuario.business.dto.UsuarioDTO;
import com.wallacecarlos.Usuario.infrastructure.entity.Usuario;
import com.wallacecarlos.Usuario.infrastructure.repository.UsuarioRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Builder

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioConverter.paraUSuario(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return usuarioConverter.paraUSuarioDTO
                ( usuario = usuarioRepository.save(usuario));

    }
}






