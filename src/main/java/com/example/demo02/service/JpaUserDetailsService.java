package com.example.demo02.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo02.repository.UserRepository;
import com.example.demo02.security.SecurityUser;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
    var user = userRepository.findUserByUsername(username);

    user.ifPresent(u -> {
      u.getAuthorities().forEach(auth -> System.out.println(auth.getName()));
    });

    return user.map(SecurityUser::new)
      .orElseThrow(() -> new UsernameNotFoundException("username: " + username + " is not found" ));
  }
  
}
