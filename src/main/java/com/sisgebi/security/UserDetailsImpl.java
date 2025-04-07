package com.sisgebi.security;

import com.sisgebi.entity.Usuario;
import com.sisgebi.enums.Status;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {
    private String correo;
    private String contrasena;
    private boolean enabled; // Ahora basado en el Status
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Usuario usuario) {
        this.correo = usuario.getCorreo();
        this.contrasena = usuario.getContrasena();
        this.enabled = usuario.getStatus() == Status.ACTIVO; // Activo si el status es ACTIVO
        this.authorities = List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().name())); // Prefijo ROLE_
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return correo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
