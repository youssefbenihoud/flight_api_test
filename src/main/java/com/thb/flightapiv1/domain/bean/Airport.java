package com.thb.flightapiv1.domain.bean;

import javax.persistence.Entity;

import javax.persistence.Id;


@Entity
public class Airport {

	
	@Id
	private String shortcut;
	private String name;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.isEmpty())
			name = "NONE";
		this.name = name;
	}
	public String getShortcut() {
		return shortcut;
	}
	public void setShortcut(String shortcut) {
		if(shortcut.isEmpty())
			shortcut = "NN";
		this.shortcut = shortcut;
	}
	
	
}
