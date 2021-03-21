package org.cfuentes.scrumapp.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class UsuarioAutenticado implements UserDetails {

    private static final long serialVersionUID = 1L;
    private Miembro miembro;

    Set<GrantedAuthority> authorities=null;

    public Miembro getUser() {
        return miembro;
    }

    public void setUser(Miembro user) {
        this.miembro = user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return miembro.getRoles();
    }

    public void setAuthorities(Set<GrantedAuthority> authorities)
    {
        this.authorities=authorities;
    }

    public String getPassword() {
        return miembro.getPassword();
    }

    public String getUsername() {
        return miembro.getEmail();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

}
