package org.cfuentes.scrumapp.service.api;

import org.cfuentes.scrumapp.entity.Miembro;
import org.cfuentes.scrumapp.service.commons.CrudOperations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService extends CrudOperations<UserDetails, Long> {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
