package za.co.pronto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.co.pronto.model.AuthUser;
import za.co.pronto.repositories.AuthUserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final AuthUser authUser = authUserRepository.findAuthUserByUsername(username);
        return buildUserDetails(authUser);
    }

    private UserDetails buildUserDetails(final AuthUser authUser) {
        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ALL")); //TODO: Fix this shit...
        final User user = new User(authUser.getUsername(), authUser.getPassword(), authorities);
        return user;
    }
}
