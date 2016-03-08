package com.mindfire.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindfire.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	@Query("select a.userRole from Role a, User b where b.email = ?1 and a.roleId = b.role.roleId")
	public List<String> findRoleByEmail(String email);
}
