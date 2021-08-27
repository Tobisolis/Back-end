package com.app.modulos.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.modulos.Repository.RepositoryUsuarios;
import com.app.modulos.Entity.Usuario;


@Service
@Transactional
public class ServiciosUsuario {
	
	
	    @Autowired
	    RepositoryUsuarios Repositoryusers;

	    public List<Usuario> list(){
	        return Repositoryusers.findAll();
	    }

	    public Optional<Usuario> getOne(int id){
	        return Repositoryusers.findById(id);
	    }

	    public Optional<Usuario> getByNombre(String nombre){
	        return Repositoryusers.findByNombre(nombre);
	    }

	    public void  save(Usuario user){
	    	Repositoryusers.save(user);
	    }

	    public void delete(int id){
	    	Repositoryusers.deleteById(id);
	    }

	    public boolean existsById(int id){
	        return Repositoryusers.existsById(id);
	    }

	    public boolean existsByNombre(String nombre){
	        return Repositoryusers.existsByNombre(nombre);
        }
}