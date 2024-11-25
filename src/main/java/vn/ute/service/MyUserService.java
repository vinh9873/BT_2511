package vn.ute.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import vn.ute.entity.Role;
import vn.ute.entity.Users;

public class MyUserService implements UserDetails {
	private static final long serialVersionUID = 1L;
	private Users user;

	public MyUserService(Users user) {
		this.user = user;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles = user.getRoles();
		List<SimpleGranted Authority> authorities = new ArrayList<>();
		for (Role role roles) {
		authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
		}

	public String getPassword() {
		return user.getPassword();
	}

	public String getUsername() {
		return user.getUsername();
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
}
