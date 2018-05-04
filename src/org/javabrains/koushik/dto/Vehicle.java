package org.javabrains.koushik.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

// Entity Object, requires mapping in hibernate.cfg.xml
@Entity
public class Vehicle {
	
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VEHICLE_ID")
	private int vehicleId;
	private String vehicleName;
	
	@ManyToMany
	private Collection<UserDetails> users = new ArrayList<UserDetails>(); 
	
	
	
	
	public Collection<UserDetails> getUsers() {
		return users;
	}
	public void setUsers(Collection<UserDetails> users) {
		this.users = users;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	

}
