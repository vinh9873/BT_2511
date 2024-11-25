package vn.ute.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	@Email
	private String email;
	@Column(length = 60, columnDefinition = "nvarchar(50) not null")
	private String name;
	private String password;
	private boolean enabled;
@ManyToMany (cascade = CascadeType.ALL, fetch FetchType.EAGER)
@JoinTable(name = "users_roles",joinColumns = @JoinColumn(name = "user_id"),inverse JoinColumns = @JoinColumn(name = "role_id") )
	private Set<Role> roles = new HashSet<>();
	public Set<vn.ute.entity.Role> getRoles() {
		return null;
	}
	public String getEmail() {
		return null;
	}
}
