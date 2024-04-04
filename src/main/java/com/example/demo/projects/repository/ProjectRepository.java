package com.example.demo.projects.repository;

import com.example.demo.projects.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
