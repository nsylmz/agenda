package com.bulut.domain;

import java.sql.Date;
import java.sql.Time;

public class Event {

	private Long id;

	private String eventName;

	private String eventDetail;

	private Date eventStartDate;

	private Time eventStartTime;

	private Date eventEndDate;

	private Time eventEndTime;

	private String eventPlace;
	
	private int eventComplete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDetail() {
		return eventDetail;
	}

	public void setEventDetail(String eventDetail) {
		this.eventDetail = eventDetail;
	}

	public Date getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public Time getEventStartTime() {
		return eventStartTime;
	}

	public void setEventStartTime(Time eventStartTime) {
		this.eventStartTime = eventStartTime;
	}

	public Date getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public Time getEventEndTime() {
		return eventEndTime;
	}

	public void setEventEndTime(Time eventEndTime) {
		this.eventEndTime = eventEndTime;
	}

	public String getEventPlace() {
		return eventPlace;
	}

	public void setEventPlace(String eventPlace) {
		this.eventPlace = eventPlace;
	}

	public int getEventComplete() {
		return eventComplete;
	}

	public void setEventComplete(int eventComplete) {
		this.eventComplete = eventComplete;
	}

}
