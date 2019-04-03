package com.ui.SpringUIdemo.repository;

import com.ui.SpringUIdemo.entity.Task;
import com.ui.SpringUIdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);
}
