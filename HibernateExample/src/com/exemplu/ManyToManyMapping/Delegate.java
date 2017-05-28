package com.exemplu.ManyToManyMapping;

import javax.persistence.*;
import java.util.*;

@Entity
public class Delegate {

	private int delegateId;
	private String delegateName;
	private List<Event> events = new ArrayList<Event>();

	@Id
	@GeneratedValue
	public int getDelegateId() {
		return delegateId;
	}

	public void setDelegateId(int delegateId) {
		this.delegateId = delegateId;
	}

	public String getDelegateName() {
		return delegateName;
	}

	public void setDelegateName(String delegateName) {
		this.delegateName = delegateName;
	}

	@ManyToMany
	@JoinTable(name = "join_delegate_event",
		joinColumns={@JoinColumn(name="delegateId")},
		inverseJoinColumns={@JoinColumn(name="eventId")})
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
