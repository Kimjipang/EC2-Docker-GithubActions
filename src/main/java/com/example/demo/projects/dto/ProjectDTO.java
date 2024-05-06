package com.example.demo.projects.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDTO {
    private long id;
    private String title;
    private String content;

    public ProjectDTO(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
