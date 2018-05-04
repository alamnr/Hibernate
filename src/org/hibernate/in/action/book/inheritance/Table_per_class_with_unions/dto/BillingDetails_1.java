package org.hibernate.in.action.book.inheritance.Table_per_class_with_unions.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetails_1 {
	
	@Id @GeneratedValue
	@Column(name="BILLING_DETAILS_ID", nullable=false)
	private Long id=null;
	@Column(name="OWNER", nullable=false)
	private String owner;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	

}
