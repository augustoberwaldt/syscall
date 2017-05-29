package com.syscall.service;

import com.syscall.domain.UserImpl;
import com.syscall.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AccountUserDetailsService implements UserDetailsService {

    private final OperadorRepository operadorRepository;

    @Autowired
    public AccountUserDetailsService(OperadorRepository operadorRepository) {
        this.operadorRepository = operadorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.operadorRepository.findByEmail(username)
                .map(account -> new UserImpl(
                        account.getEmail(),
                        account.getSenha(),
                        AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER")
                )).orElseThrow(() -> new UsernameNotFoundException("couldn't find " + username + "!"));
    }
}
