package com.app.modulos.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombres",length= 50 ,nullable=false)
    private String nombre;
	
	@Column(name="telefono")
	private int celular;
	
	@Column(name="correos",length= 50 ,nullable=false)
	private String correo;
	
	 
	@ManyToOne
	@JoinColumn(name="idwork")
    private Labor trabajo;
	
	
    public Usuario(){
    	
    }


	public Usuario(String nombre, int celular, String correo, Labor trabajo) {
	
		this.nombre = nombre;
		this.celular = celular;
		this.correo = correo;
		this.trabajo = trabajo;
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


	public int getCelular() {
		return celular;
	}


	public void setCelular(int celular) {
		this.celular = celular;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public Labor getTrabajo() {
		return trabajo;
	}


	public void setTrabajo(Labor trabajo) {
		this.trabajo = trabajo;
	}
    
    
    
    
    
}
