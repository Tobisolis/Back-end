package com.app.modulos.DTO;

import javax.validation.constraints.NotBlank;

public class DteoLabor {
	
	 @NotBlank
	private String nombre;
	 
	 @NotBlank
	 private String asenso;
	 

	 public DteoLabor(){
	    
	 }

	 public DteoLabor(@NotBlank String nombre,@NotBlank String asenso) {
	     this.nombre = nombre;
	     this.asenso= asenso;
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

	public void setAsenso(String asenso) {
		this.asenso = asenso;
	}

	 

}
