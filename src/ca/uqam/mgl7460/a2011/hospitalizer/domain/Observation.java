package ca.uqam.mgl7460.a2011.hospitalizer.domain;

import java.util.*;

public class Observation {
	private Date recordedDate;
	private Date observedDate;
	private String description;
	
	public Observation(Date recorderDate, Date observedDate, String description) {
		super();
		this.recordedDate = recorderDate;
		this.observedDate = observedDate;
		this.description = description;
	}
	public Date getRecordedDate() {
		return recordedDate;
	}
	public void setRecordedDate(Date recordedDate) {
		this.recordedDate = recordedDate;
	}
	public Date getObservedDate() {
		return observedDate;
	}
	public void setObservedDate(Date observedDate) {
		this.observedDate = observedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
