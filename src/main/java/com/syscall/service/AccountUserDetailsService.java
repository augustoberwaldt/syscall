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

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AccountUserDetailsService implements UserDetailsService {

    private final OperadorRepository operadorRepository;

    private  final NotificationService notificationService;
    
    @Autowired
    public AccountUserDetailsService(OperadorRepository operadorRepository, NotificationService notificationService) {
    	this.notificationService =  notificationService;
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
    
    
    public boolean existAccount (String email) {
    	return this.operadorRepository.findByEmail(email).isPresent();
    }
    
    public void  sendPasswordMail(String email) {
        
    	String newPass = RandomGenerator.generateRandom(6);
        this.updatePassword(newPass,
              this.operadorRepository.findByEmail(username)   
        );
        
    	Map<String,String> options = new HashMap();
    	options.put("to", email);
    	options.put("subject", "SYSCALL - Recuperação de senha");
    	options.put("text", "NOVA SENHA :" + newPass);
    	
    	this.notificationService.sendNotification(options);
    }
    
    
    private String updatePassword(String pass, Operador operador) {
        operador.setSenha((new BCryptPasswordEncoder(pass)).toString());
        this.operadorRepository.save(operador);    
    }
    
}
