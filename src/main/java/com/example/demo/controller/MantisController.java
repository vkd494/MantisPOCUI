package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MantisDto;
import com.example.demo.entity.Mantis;
import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.MantisService;

@RestController
@RequestMapping("/api")
public class MantisController {
    @Autowired
    private MantisService mantisService;
    
    @Autowired
    private ProjectRepository projectRepository;
    
    @CrossOrigin(origins = "*")
    @GetMapping("/mantis/{projectId}")
    public List<Mantis> getMantisIdsByProject(@PathVariable int projectId) {
        return mantisService.getMantisIdsByProject(projectId);
    }
    
    @PostMapping("/saveMantis")
    public ResponseEntity<String> saveMantis(@RequestBody MantisDto mantisDto){
    	Project project = projectRepository.findById(mantisDto.getMantisId())
    			.orElseThrow(() -> new IllegalArgumentException("Invalid project ID"));
    	
    	Mantis mantis = new Mantis();
    	mantis.setMantisId(mantisDto.getMantisId());
    	mantis.setProject(project);
    	
    	mantisService.saveMantis(mantis);
    	
    	return new ResponseEntity<>("Mantis record saved succ", HttpStatus.CREATED);
    }
}

