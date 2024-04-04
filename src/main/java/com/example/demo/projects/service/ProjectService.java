package com.example.demo.projects.service;

import com.example.demo.projects.model.Project;
import com.example.demo.projects.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Optional<Project> findById(Long project_Id) {
        Optional<Project> project = projectRepository.findById(project_Id);
        return project;
    }

    public Project createProject(Project project) {
        projectRepository.save(project);
        return project;
    }

    public Project updateProject(Long projectId, Project project) {
        Optional<Project> updated = projectRepository.findById(projectId);
        if (updated.isPresent()) {
            Project updatedProject = updated.get();
            updatedProject.setTitle(project.getTitle());
            updatedProject.setContent(project.getContent());

            return projectRepository.save(updatedProject);
        }
        return null;
    }
}
