package com.noesis.domain.dto;

public class NumberRoutingClientData {
	private String name;
	private String id;
	public NumberRoutingClientData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NumberRoutingClientData(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "NumberRoutingClientData [name=" + name + ", id=" + id + "]";
	}
	
}
