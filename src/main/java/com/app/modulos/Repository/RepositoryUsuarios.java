package com.app.modulos.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.modulos.Entity.Usuario;

@Repository
public interface RepositoryUsuarios extends JpaRepository<Usuario ,Integer>{
	
	Optional<Usuario> findByNombre(String nombre);
    boolean existsByNombre(String nombre);  
    boolean existsById(int id);

}
