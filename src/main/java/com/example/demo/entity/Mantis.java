package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Mantis {
    @Id
    @Column(name = "mantis_id")
    private int mantisId;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

	public int getMantisId() {
		return mantisId;
	}

	public void setMantisId(int mantisId) {
		this.mantisId = mantisId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	} 
}
