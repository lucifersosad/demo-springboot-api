package spring.security.demonht.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import spring.security.demonht.entity.RoleEntity;
import spring.security.demonht.entity.UserEntity;

import java.io.Serial;
import java.util.*;
import java.util.stream.Collectors;

public class MyUserService implements UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;
    private UserEntity user;

    private List<GrantedAuthority> authorities;

    public MyUserService(UserEntity user) {
        this.user = user;
        Set<RoleEntity> roles = user.getRoles();
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        this.authorities = authorities;
    }

//    public MyUserService(UserEntity user) {
//        this.user = user;
//    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
         return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getEnabled();
    }
}
