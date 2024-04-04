package com.example.demo.projects.controller;

import com.example.demo.projects.dto.ProjectDTO;
import com.example.demo.projects.dto.ProjectResponse;
import com.example.demo.projects.model.Project;
import com.example.demo.projects.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/projects")
public class ProjectController {

    private final ProjectService projectService;

    ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = projectService.findAll();

        List<ProjectDTO> projectDTOS = projects.stream().map(project -> new ProjectDTO(project.getId(), project.getTitle())).collect(Collectors.toList());
        return projectDTOS;
    }

    @GetMapping("/{project_id}")
    public ProjectDTO getProject(@PathVariable Long project_id) {
        Project project = projectService.findById(project_id).orElse(null);

        if (project != null) {
            ProjectDTO projectDTO = new ProjectDTO(project.getId(), project.getTitle());
            return projectDTO;
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody Project project) {
        projectService.createProject(project);
        ProjectResponse response = new ProjectResponse("Project created successfully", project);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{project_id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long project_id, @RequestBody Project project) {
        Project updateProject = projectService.updateProject(project_id, project);
        if (updateProject != null) {
            ProjectResponse response = new ProjectResponse("Project updated successfully", project);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        return null;
    }
}
