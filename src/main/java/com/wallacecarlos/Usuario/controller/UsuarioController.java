package com.wallacecarlos.Usuario.controller;


import com.wallacecarlos.Usuario.business.UsuarioService;
import com.wallacecarlos.Usuario.business.dto.UsuarioDTO;
import com.wallacecarlos.Usuario.infrastructure.entity.Usuario;
import com.wallacecarlos.Usuario.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor

public class UsuarioController {
    private  final UsuarioService usuarioService;
    private  final AuthenticationManager authenticationManager;
    private  final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity <UsuarioDTO>salvarUsuario(@RequestBody UsuarioDTO usuarioDTO){
       return ResponseEntity.ok( usuarioService.salvarUsuario(usuarioDTO));

    }

    @PostMapping("/login")
    public String login(@RequestBody UsuarioDTO usuarioDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        usuarioDTO.getEmail(),
                        usuarioDTO.getSenha()
                )
        );

        return "bearer " + jwtUtil.generateToken(authentication.getName());
    }
    @GetMapping

    public ResponseEntity <Usuario> buscarUsuarioPorEmail(@RequestParam("email") String email){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPoremail(email));
    }

    @DeleteMapping("/{email}")

    public ResponseEntity<Void>deletarUsuariooPorEmail(@PathVariable String email){
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();

    }
}
