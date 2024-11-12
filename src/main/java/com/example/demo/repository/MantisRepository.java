package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Mantis;

public interface MantisRepository extends JpaRepository<Mantis, Integer> {
    List<Mantis> findByProjectId(int projectId);
    Optional<Mantis> findByMantisId(int mantisId);
}

