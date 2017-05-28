package com.exemplu.ManyToManyMapping;

import java.util.*;

import javax.persistence.*;

@Entity
public class Event {

	private int eventId;
	private String eventName;
	private List<Delegate> delegates = new ArrayList<Delegate>();

	@Id
	@GeneratedValue
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@ManyToMany
	@JoinTable(name = "join_delegate_event",
			joinColumns={@JoinColumn(name="eventId")},
			inverseJoinColumns={@JoinColumn(name="delegateId")})
	public List<Delegate> getDelegates() {
		return delegates;
	}

	public void setDelegates(List<Delegate> delegates) {
		this.delegates = delegates;
	}

}
