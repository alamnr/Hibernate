package org.hibernate.in.action.book.inheritance.single_table.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="BILLING_DETAILS_TYPE",discriminatorType=DiscriminatorType.STRING)
public abstract class BillingDetails_2 {
	
	@Id @GeneratedValue
	@Column(name="BILLING_DETAILS_ID")
	private Long id=null;
	
	@Column(name="OWNER", nullable=false)
	private String owner;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	

}
