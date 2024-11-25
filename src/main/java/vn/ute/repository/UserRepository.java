package vn.ute.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import vn.ute.entity.Users;

public interface UserRepository {

	@Query("SELECT u FROM Users u WHERE u.username = :username")
	public Users getUserByUsername(@Param("username") String username);

	Optional<Users> findByEmail(String email);

	Optional<Users> findByUsernameOrEmail(String username, String email);

	Optional<Users> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
