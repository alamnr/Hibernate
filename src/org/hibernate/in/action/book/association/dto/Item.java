package org.hibernate.in.action.book.association.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class Item {
	
	@Id @GeneratedValue
	@Column(name="ITEM_ID")
	private Long id =null;
	
	@OneToMany(mappedBy="item", fetch=FetchType.EAGER)
	private Collection<Bid> bids = new ArrayList<Bid>();
	//private Set<Bid> bids = new HashSet<Bid>();
	
	@Column(name="ITEM_NAME")
	private String itemName;
	
	
	
	 public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	/*public Set<Bid> getBids() {
		return bids;
	}



	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}
*/


	public Collection<Bid> getBids() {
		return bids;
	}



	public void setBids(Collection<Bid> bids) {
		this.bids = bids;
	}



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public void addBid(Bid bid) {
	        bid.setItem(this);
	        bids.add(bid);
	    }

}
