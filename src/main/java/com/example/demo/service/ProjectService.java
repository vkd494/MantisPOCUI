package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    
    public Project saveProject(Project project) {
    	return projectRepository.save(project);
    }
}
