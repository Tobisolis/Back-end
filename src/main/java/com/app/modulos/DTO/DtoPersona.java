package com.app.modulos.DTO;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


public class DtoPersona {
	
	
	
	 @NotBlank
	 private String nombre;
	 
	 @Min(0)
	 private int celular;
	 
	 @NotBlank
	 private String correo;
	 

	 public DtoPersona(){
	    
	 }

	 public DtoPersona(@NotBlank String nombre, @Min(0) Integer celular,@NotBlank String correo) {
	     this.nombre = nombre;
	     this.celular = celular;
	     this.correo = correo;
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
	 
	 

}
