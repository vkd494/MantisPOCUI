package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MantisIntegrationDto;
import com.example.demo.entity.Mantis;
import com.example.demo.entity.MantisIntegration;
import com.example.demo.repository.MantisRepository;
import com.example.demo.service.MantisIntegrationService;

@RestController
@RequestMapping("/api/mantis-integration")
public class MantisIntegrationController {
    @Autowired
    private MantisIntegrationService mantisIntegrationService;

    @Autowired
    private MantisRepository mantisRepository; 

    
    @CrossOrigin(origins = "*")
    @PostMapping("/postMantisIntegration")
    public ResponseEntity<String> postMantisIntegration(@RequestBody MantisIntegrationDto dto) {
        MantisIntegration mantisIntegration = new MantisIntegration();
        mantisIntegration.setReason(dto.getReason());
        mantisIntegration.setRunQuery(dto.getRunQuery());

     
        Mantis mantis = mantisRepository.findByMantisId(dto.getMantisId())
            .orElseThrow(() -> new IllegalArgumentException("Invalid Mantis ID"));

        mantisIntegration.setMantis(mantis);

        mantisIntegrationService.saveMantisIntegration(mantisIntegration);
        return ResponseEntity.ok("Data saved successfully!");
    }
}
