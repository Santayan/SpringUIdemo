package com.ui.SpringUIdemo.repository;

import com.ui.SpringUIdemo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {
}
