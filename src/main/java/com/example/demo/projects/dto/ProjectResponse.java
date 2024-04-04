package com.example.demo.projects.dto;

import com.example.demo.projects.model.Project;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectResponse {

    private String msg;
    private Project data;
    public ProjectResponse(String msg, Project data) {
        this.msg = msg;
        this.data = data;
    }

}
