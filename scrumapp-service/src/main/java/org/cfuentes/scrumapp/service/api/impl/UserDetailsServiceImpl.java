package org.cfuentes.scrumapp.service.api.impl;

import org.cfuentes.scrumapp.entity.Miembro;
import org.cfuentes.scrumapp.entity.UsuarioAutenticado;
import org.cfuentes.scrumapp.repository.MiembroRepository;
import org.cfuentes.scrumapp.service.api.MiembroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    MiembroRepository miembroRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Miembro miembroApp = miembroRepository.findMiembroByEmail("jose");

        List<GrantedAuthority> grantList = new ArrayList();
        GrantedAuthority grantedRole = new SimpleGrantedAuthority(miembroApp.getRol());
        grantList.add(grantedRole);
        miembroApp.setRoles(grantList);

        //UserDetails user = (UserDetails) new Miembro(miembroApp.getEmail(), miembroApp.getPassword(), grantList);
        UsuarioAutenticado user = new UsuarioAutenticado();
        user.setUser(miembroApp);
        return user;
    }


}
