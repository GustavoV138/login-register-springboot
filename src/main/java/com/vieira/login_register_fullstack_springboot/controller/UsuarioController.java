package com.vieira.login_register_fullstack_springboot.controller;

import com.vieira.login_register_fullstack_springboot.model.UsuarioEntity;
import com.vieira.login_register_fullstack_springboot.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@RequestBody UsuarioEntity usuario) {
        if(usuario == null) {
            return ResponseEntity.badRequest().body("Alguns campos não foram inseridos");
        }
        // Se a condicao for false, ou seja, se já houver algum usuario com o login,
        // o if retorna o badRequest().
        if(!usuarioService.verificarUsuarioExistente(usuario)) {
            return ResponseEntity.badRequest().body("Credenciais já em uso");
        }
        usuarioService.registrarUsuario(usuario);
        return ResponseEntity.ok("Tudo certo!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> logarUsuario(@RequestBody UsuarioEntity usuario) {
        boolean novoUsuario = usuarioService.logarUsuario(usuario);
        if(novoUsuario == true){
            return ResponseEntity.status(200).body(novoUsuario);
        } else {
            return ResponseEntity.badRequest().body("Login e senha não correspondem");
        }

    }
}
