package com.app.modulos.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.modulos.Entity.Labor;

@Repository
public interface RepositoryLabor extends JpaRepository<Labor ,Integer> {
	
	Optional<Labor> findByNombre(String nombre);
    boolean existsByNombre(String nombre);

}
