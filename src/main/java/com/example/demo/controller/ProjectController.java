package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private ProjectRepository pr;

    
    @CrossOrigin(origins = "*")
    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }
    
    @PostMapping("/saveProject")
    public ResponseEntity<Project> saveProject(@RequestBody Project project){
    	Project saveProject = pr.save(project);
    	return new ResponseEntity<>(saveProject, HttpStatus.CREATED);
    }
}

