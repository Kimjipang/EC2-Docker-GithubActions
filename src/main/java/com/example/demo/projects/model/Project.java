package com.example.demo.projects.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "project_title", nullable = false, length = 12)
    private String title;

    @Column(name = "project_content", nullable = false, length = 20)
    private String content;
}
