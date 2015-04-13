package edu.neu.cs5200.jpa.models;

import javax.persistence.*;

@Entity
public class Tower {
	@Id
	private int id;
	private String name;
	private double height;
	private int sides;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="siteId") //two tables are mapped to each other by siteId
	private Site site;
	
	public Tower(int id, String name, double height, int sides, int siteId) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.sides = sides;
	}
	public Tower() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getSides() {
		return sides;
	}
	public void setSides(int sides) {
		this.sides = sides;
	}

	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	
	
}
