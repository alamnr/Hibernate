package org.hibernate.in.action.book.inheritance.single_table.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@DiscriminatorValue("CC")
public class CreditCard_2 extends BillingDetails_2{
	
	
	@Column(name="CC_NUMBER")
	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
	

}
