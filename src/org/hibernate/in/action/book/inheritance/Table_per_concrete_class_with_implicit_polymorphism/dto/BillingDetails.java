package org.hibernate.in.action.book.inheritance.Table_per_concrete_class_with_implicit_polymorphism.dto;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BillingDetails {
	
	@Column(name="OWNER", nullable=false)
	private String owner;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	

}
