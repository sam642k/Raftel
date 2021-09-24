/*
 * package com.raftel.userservice;
 * 
 * import java.util.ArrayList; import java.util.HashSet; import java.util.List;
 * import java.util.Set;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * @Service public class CustomUserDetailsService implements UserDetailsService
 * {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * public User findUserByEmail(String email) { return
 * userRepository.findByEmail(email); }
 * 
 * 
 * @Override public UserDetails loadUserByUsername(String email) throws
 * UsernameNotFoundException { User user = userRepository.findByEmail(email);
 * System.out.println(user); if(user != null) { Set<GrantedAuthority>
 * authorities = new HashSet<>(); authorities.add(new
 * SimpleGrantedAuthority(user.getRoles())); System.out.println(authorities);
 * return buildUserForAuthentication(user, authorities); } else { throw new
 * UsernameNotFoundException("username not found"); } }
 * 
 * 
 * private UserDetails buildUserForAuthentication(User user,
 * Set<GrantedAuthority> authorities) { return new
 * org.springframework.security.core.userdetails.User(user.getEmail(),
 * user.getPassword(), authorities); }
 * 
 * }
 */