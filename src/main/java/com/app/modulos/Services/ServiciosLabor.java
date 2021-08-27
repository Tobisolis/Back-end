package com.app.modulos.Services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.modulos.Entity.Labor;
import com.app.modulos.Repository.RepositoryLabor;


@Service
@Transactional
public class ServiciosLabor {
	
		
		    @Autowired
		    RepositoryLabor Repositoryworks;

		    public List<Labor> list(){
		        return Repositoryworks.findAll();
		    }

		    public Optional<Labor> getOne(int id){
		        return Repositoryworks.findById(id);
		    }

		    public Optional<Labor> getByNombre(String work){
		        return Repositoryworks.findByNombre(work);
		    }

		    public void  save(Labor work){
		    	Repositoryworks.save(work);
		    }

		    public void delete(int id){
		    	Repositoryworks.deleteById(id);
		    }

		    public boolean existsById(int id){
		        return Repositoryworks.existsById(id);
		    }

		    public boolean existsByNombre(String work){
		        return Repositoryworks.existsByNombre(work);
	        }

}
