package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Mantis;
import com.example.demo.repository.MantisRepository;

@Service
public class MantisService {
    @Autowired
    private MantisRepository mantisRepository;

    public List<Mantis> getMantisIdsByProject(int projectId) {
        return mantisRepository.findByProjectId(projectId);
    }
    
    public Mantis saveMantis(Mantis mantis) {
    	return mantisRepository.save(mantis);
    }
}
