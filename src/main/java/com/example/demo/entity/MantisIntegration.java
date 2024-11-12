package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class MantisIntegration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String reason;

    private String runQuery;

    @OneToOne
    @JoinColumn(name = "mantis_id", nullable = false)
    private Mantis mantis;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getRunQuery() {
		return runQuery;
	}

	public void setRunQuery(String runQuery) {
		this.runQuery = runQuery;
	}

	public Mantis getMantis() {
		return mantis;
	}

	public void setMantis(Mantis mantis) {
		this.mantis = mantis;
	}
    // Getters and Setters
}
