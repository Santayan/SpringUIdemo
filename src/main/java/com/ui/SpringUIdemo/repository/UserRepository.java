package com.ui.SpringUIdemo.repository;

import com.ui.SpringUIdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
