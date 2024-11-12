package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MantisIntegration;
import com.example.demo.repository.MantisIntegrationRepository;

@Service
public class MantisIntegrationService {
	
	
    @Autowired
    private MantisIntegrationRepository mantisIntegrationRepository;

    public MantisIntegration saveMantisIntegration(MantisIntegration mantisIntegration) {
        return mantisIntegrationRepository.save(mantisIntegration);
    }
}
