package vn.ute.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import vn.ute.entity.Role;
import vn.ute.entity.Users;
import vn.ute.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	private UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

public UserDetails loadUserByUsername (String usernameOrEmail) throws UsernameNotFoundException {
  Users user = userRepository.findByUsernameOrEmail (usernameOrEmail, usernameOrEmail).orElseThrow(() ->
new UsernameNotFoundException("User not found with username or email:" + usernameOrEmail));
return new org.springframework.security.core.userdetails. User(user.getEmail(), user.getPassword(),mapRolesToAuthorities (user.getRoles()));
}

private Collection< ? extends GrantedAuthority> mapRolesToAuthorities (Set<Role> roles) {
	return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
 }
}
