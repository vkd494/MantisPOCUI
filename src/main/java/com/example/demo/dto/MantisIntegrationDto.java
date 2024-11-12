package com.example.demo.dto;

public class MantisIntegrationDto {
	
    private int mantisId;
    
    private String reason;
    
    private String runQuery;
    
	public int getMantisId() {
		return mantisId;
	}
	
	public void setMantisId(int mantisId) {
		this.mantisId = mantisId;
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
    
}

