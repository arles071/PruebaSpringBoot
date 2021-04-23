package com.tiendalibros.com.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	
	private static final long serialVersionUID = -591352036626114525L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 50)
	private String autor;
	
	@Column(length = 50)
	private String categoria;
	private int cuantityAvailable;
	private int reserveAmount;
	private float cost;
	private boolean status;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getCuantityAvailable() {
		return cuantityAvailable;
	}
	public void setCuantityAvailable(int cuantityAvailable) {
		this.cuantityAvailable = cuantityAvailable;
	}
	public int getReserveAmount() {
		return reserveAmount;
	}
	public void setReserveAmount(int reserveAmount) {
		this.reserveAmount = reserveAmount;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
