package org.hibernate.in.action.book.inheritance.Table_per_class_with_unions.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEBIT_CARD")
public class DebitCard_1 extends BillingDetails_1 {
	
	
	@Column(name="NUMBER", nullable=false)
	private String number;

	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	

}
