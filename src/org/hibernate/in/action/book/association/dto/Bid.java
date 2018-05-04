package org.hibernate.in.action.book.association.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "BID")
public class Bid {

	@Id
	@GeneratedValue
	@Column(name = "BID_ID")
	private Long id = null;

	@ManyToOne(targetEntity = org.hibernate.in.action.book.association.dto.Item.class)
	@JoinColumn(name = "ITEM_ID", nullable = false)
	private Item item;

	@Column(name = "AMOUNT")
	private double amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
