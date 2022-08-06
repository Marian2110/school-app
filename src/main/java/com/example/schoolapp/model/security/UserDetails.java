package com.example.schoolapp.model.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public record UserDetails(
        String username,
        String password,
        List<String> roles) implements org.springframework.security.core.userdetails.UserDetails {
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Optional.ofNullable(roles)
                .map(myRoles -> myRoles.stream()
                        .map(SimpleGrantedAuthority::new)
                        .toList())
                .orElseGet(List::of);
    }

}
