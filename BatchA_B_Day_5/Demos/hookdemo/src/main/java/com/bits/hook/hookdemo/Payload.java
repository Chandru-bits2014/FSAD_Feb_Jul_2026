package com.bits.hook.hookdemo;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Payload {

	@JsonProperty("event_type")//JSON PROPERTY TO BE SENT
	private String eventType;

	
	public Payload() {
		super();
	}


	public Payload(String eventType) {
		super();
		this.eventType = eventType;
	}


	public String getEventType() {
		return eventType;
	}


	public void setEventType(String eventType) {
		this.eventType = eventType;
	}


	@Override
	public String toString() {
		return "Payload [eventType=" + eventType + "]";
	}
	
	
	
}
