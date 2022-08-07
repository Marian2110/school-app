package com.example.schoolapp.model.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public record CustomUserDetails(
        String username,
        String password,
        String userClass,
        List<String> roles) implements UserDetails {
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

    public String getUserClass() {
        return userClass;
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
