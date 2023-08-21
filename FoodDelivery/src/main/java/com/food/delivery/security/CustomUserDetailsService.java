package com.food.delivery.security;

/**
 * @author Z003YZ0D Akshay Sahu
 */
import com.food.delivery.entity.Vendor;
import com.food.delivery.repository.VendorRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private VendorRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Vendor user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

        Set<GrantedAuthority> authorities = new HashSet<>();

        return new org.springframework.security.core.userdetails.User(
                email,
                user.getPassword(),
                authorities
        );
    }
}
