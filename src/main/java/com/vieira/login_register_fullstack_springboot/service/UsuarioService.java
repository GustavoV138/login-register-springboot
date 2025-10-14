package com.vieira.login_register_fullstack_springboot.service;

import com.vieira.login_register_fullstack_springboot.model.UsuarioEntity;
import com.vieira.login_register_fullstack_springboot.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void registrarUsuario(UsuarioEntity usuario) {
        UsuarioEntity usuarioExistente = usuarioRepository.findByLogin(usuario.getLogin()).orElse(null);

        if(usuarioExistente == null || usuarioExistente.getSenha() == null || usuarioExistente.getLogin() == null){
            UsuarioEntity novoUsuario = new UsuarioEntity(usuario.getLogin(), usuario.getSenha());
            usuarioRepository.save(novoUsuario);
        } else {
            System.out.println("Credenciais já em uso");
        }
    }

    public boolean logarUsuario(UsuarioEntity usuario) {

        UsuarioEntity novoUsuario = usuarioRepository.findByLogin(usuario.getLogin()).orElse(null);

        if(novoUsuario == null || novoUsuario.getSenha() == null || novoUsuario.getLogin() == null){
            System.out.println("Até aqui chegou");
            return false;
        }

        if(usuario.getSenha().equals(novoUsuario.getSenha())) {
            System.out.println(usuario);
            return true;
        } else {
            System.out.println("Ou então até aqui");
            return false;
        }
    }

    public boolean verificarUsuarioExistente(UsuarioEntity usuario) {
        UsuarioEntity usuarioExistente = usuarioRepository.findByLogin(usuario.getLogin()).orElse(null);
        // Se já houver algum usuario existente com o login, a condicao retorna false
        // e faz com que o endpoint retorne um badRequest().
        if(usuarioExistente == null){
            return true;
        } else {
            return false;
        }
    }
}
