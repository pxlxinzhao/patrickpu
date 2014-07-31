package com.javahash.spring.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "GPSuserinfo")
public class User implements Serializable{
	
	public User() {	super(); }

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="seq",initialValue=101, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	private int Geoinfo_id;
	@Column(nullable=false)
	private String username;
	@Column
	private String latitude;
	@Column
	private String longtitude;

	
	public int getGeoinfo_id() {
		return Geoinfo_id;
	}
	public void setGeoinfo_id(int geoinfo_id) {
		Geoinfo_id = geoinfo_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

}
