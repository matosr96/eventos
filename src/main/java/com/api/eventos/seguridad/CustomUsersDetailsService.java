package com.api.eventos.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.eventos.entidades.Usuario;
import com.api.eventos.repositorios.UsuarioRepositorio;

import java.util.ArrayList;

@Service
public class CustomUsersDetailsService implements UserDetailsService {
    private UsuarioRepositorio usuariosRepo;

    @Autowired
    public CustomUsersDetailsService(UsuarioRepositorio usuariosRepo) {
        this.usuariosRepo = usuariosRepo;
    }

    // Método para traernos un usuario con todos sus datos por medio de su correo electrónico
    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuarios = usuariosRepo.findByCorreo(correo).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return new User(usuarios.getCorreo(), usuarios.getContraseña(), new ArrayList<>());  
    }
}