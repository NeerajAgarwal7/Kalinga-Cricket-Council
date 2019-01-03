package com.mindtree.kcc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Type {

	@Id
	private int typeId;
	private String name;

	public Type() {
		super();
	}

	public Type(int typeId, String name) {
		super();
		this.typeId = typeId;
		this.name = name;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", name=" + name + "]";
	}

}
