package org.hibernate.in.action.book.selfAssociationAndValueType.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

public class Item {
	private String name;
    private String description;
    
    @Column(name = "INITIAL_PRICE",
            columnDefinition = "number(10,2) default '1'")
    @org.hibernate.annotations.Generated(
        org.hibernate.annotations.GenerationTime.INSERT
    )
    private BigDecimal initialPrice;
    
    private Set<Category> categories = new HashSet<Category>();
    
    
    
    
    public BigDecimal getInitialPrice() {
		return initialPrice;
	}
	public void setInitialPrice(BigDecimal initialPrice) {
		this.initialPrice = initialPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	/*public void addCategory(Category category) {
        if (category == null)
            throw new IllegalArgumentException("Null category");
        category.getItems().add(this);
        categories.add(category);
    }*/

}
