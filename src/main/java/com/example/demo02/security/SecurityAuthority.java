package com.example.demo02.security;

import org.springframework.security.core.GrantedAuthority;

import com.example.demo02.entity.Authority;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

  private Authority authority;

  @Override
  public String getAuthority() {
    return authority.getName();
  }
  
}
