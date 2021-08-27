package com.app.modulos.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Labor")
public class Labor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre_labor",length= 50 ,nullable=false)
    private String nombre;
	 
	@Column(name="posibilidad_asenso",length= 50 ,nullable=false)
    private String asenso;

	
	public Labor() {
		
	}


	public Labor(String nombre, String asenso) {
		
		this.nombre = nombre;
		this.asenso = asenso;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getAsenso() {
		return asenso;
	}


	public void setAscnso(String asenso) {
		this.asenso = asenso;
	}
	
	
	
	
}
