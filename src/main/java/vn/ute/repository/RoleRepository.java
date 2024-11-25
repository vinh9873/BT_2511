package vn.ute.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.ute.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	@Query("SELECT u FROM Role u WHERE u.name = :name")
	public Role getUserByName(@Param("name") String name);

	Optional<Role> findByName(String name);
}
