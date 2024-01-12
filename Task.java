package com.example.taskapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "tasks")
public class Task {
    @Id
    private String id;
    private String name;
    private String assignee;
    private String project;
    private LocalDateTime startTime;
    private String rajeshSinghProperty;

    public Task() {
        // Default constructor
    }

    public Task(String name, String assignee, String project, LocalDateTime startTime) {
        this.name = name;
        this.assignee = assignee;
        this.project = project;
        this.startTime = startTime;
        // Generate rajeshSinghProperty here
        this.rajeshSinghProperty = generateRajeshSinghProperty();
    }

    // Getters and setters

    private String generateRajeshSinghProperty() {
        // Logic to generate rajeshSinghProperty
        String candidateName = "RajeshSingh";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int randomIndex = (int) (Math.random() * candidateName.length());
            result.append(candidateName.charAt(randomIndex));
        }
        return result.toString();
    }
}
