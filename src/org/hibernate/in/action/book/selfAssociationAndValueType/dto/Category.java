package org.hibernate.in.action.book.selfAssociationAndValueType.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORY")
@org.hibernate.annotations.GenericGenerator(
	    name = "hibernate-uuid",
	    strategy = "uuid" 
	)
public class Category {
	
	@Id @GeneratedValue(generator = "hibernate-uuid")
	@Column(name="GENERATED_ID")
	private String id;
	//private Long id;
	
	private String name;
	@OneToOne
	@JoinColumn(name="PARENT_ID")
	private Category parentCategory;
	@OneToMany
	
	private Set<Category> childCategories = new HashSet<Category>();
	
	
	//private Set<Item> items = new HashSet<Item>();
    
   
    
    
	/*public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}*/
	/*public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}*/
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
	public Set<Category> getChildCategories() {
		return childCategories;
	}
	public void setChildCategories(Set<Category> childCategories) {
		this.childCategories = childCategories;
	}
	
	
	public void addChildCategory(Category childCategory) {
	     if (childCategory == null)
	      throw new IllegalArgumentException("Null child category!");
	     if (childCategory.getParentCategory() != null)
	      childCategory.getParentCategory().getChildCategories()
	                                         .remove(childCategory);
	    childCategory.setParentCategory(this);
	    childCategories.add(childCategory);
	}
	

}
