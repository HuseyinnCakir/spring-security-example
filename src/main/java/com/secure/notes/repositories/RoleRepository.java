package com.secure.notes.repositories;

import com.secure.notes.entity.AppRole;
import com.secure.notes.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);

}
