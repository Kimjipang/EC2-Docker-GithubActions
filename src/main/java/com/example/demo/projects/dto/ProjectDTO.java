package com.example.demo.projects.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDTO {
    private long id;
    private String title;

    public ProjectDTO(long id, String title) {
        this.id = id;
        this.title = title;
    }
}
