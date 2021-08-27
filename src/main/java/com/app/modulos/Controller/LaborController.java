package com.app.modulos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;

import com.app.modulos.DTO.DteoLabor;
import com.app.modulos.Entity.Labor;
import com.app.modulos.Services.ServiciosLabor;


@RestController
@RequestMapping("/trabajos")
@CrossOrigin(origins ="http://localhost:4200")
public class LaborController {
	
	
	@Autowired
	ServiciosLabor serviceWork;
	
	 @GetMapping("/lista")
	  public ResponseEntity<List<Labor>> list(){
	       List<Labor> list = serviceWork.list();
	       return new ResponseEntity<List<Labor>>(list, HttpStatus.OK);
	    }

	    @GetMapping("/detalles/{id}")
	    public ResponseEntity<Labor> getById(@PathVariable("id") int id){
	        if(!serviceWork.existsById(id))
	            return new ResponseEntity<Labor>(HttpStatus.NOT_FOUND);
	        Labor work = serviceWork.getOne(id).get();
	        return new ResponseEntity<Labor>(work, HttpStatus.OK);
	    }

	    @GetMapping("/detallesforName/{nombre}")
	    public ResponseEntity<Labor> getByNombre(@PathVariable("nombre") String nombre){
	        if(!serviceWork.existsByNombre(nombre))
	            return new ResponseEntity<Labor>(HttpStatus.NOT_FOUND);
	        Labor trabajo = serviceWork.getByNombre(nombre).get();
	        return new ResponseEntity<Labor>(trabajo, HttpStatus.OK);
	    }

	    @PostMapping("/create")
	    public ResponseEntity<?> create(@RequestBody DteoLabor dtol){
	    	System.out.println(dtol.getNombre() +"-----"+dtol.getAsenso());
	        if(StringUtils .isBlank(dtol.getNombre()))
	            return new ResponseEntity<Labor>(HttpStatus.BAD_REQUEST);
	        if(StringUtils .isBlank(dtol.getAsenso()))
	            return new ResponseEntity<Labor>(HttpStatus.BAD_REQUEST);
	        if(serviceWork.existsByNombre(dtol.getNombre()))
	            return new ResponseEntity<Labor>(HttpStatus.BAD_REQUEST);
	        Labor work = new Labor(dtol.getNombre(), dtol.getAsenso());
	        
	        serviceWork.save(work);
	        return new ResponseEntity<Labor>(work,HttpStatus.OK) ;
	    }
        
	    @PutMapping("/update/{id}")
	    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody Labor dtol){
	        if(!serviceWork.existsById(id))
	            return new ResponseEntity<Labor>(HttpStatus.NOT_FOUND);
	        if(serviceWork.existsByNombre(dtol.getNombre()) && serviceWork.getByNombre(dtol.getNombre()).get().getId() != id)
	            return new ResponseEntity<Labor>(HttpStatus.BAD_REQUEST);
	        if(StringUtils.isBlank(dtol.getAsenso()))
	            return new ResponseEntity<Labor>(HttpStatus.BAD_REQUEST);

	        Labor work = serviceWork.getOne(id).get();
	        work.setNombre(dtol.getNombre());
	        work.setAscnso(dtol.getAsenso());
	        serviceWork.save(work);
	        return new ResponseEntity<Labor>(work,HttpStatus.OK);
	    } 

	   /* 
	    * NO ES NECESARIO BORRAR UNA LABOR
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> delete(@PathVariable("id")int id){
	    	System.out.println("---------"+id);
	        if(!serviceWork.existsById(id))
	            return new ResponseEntity<Labor>(HttpStatus.NOT_FOUND);
	        serviceWork.delete(id);
	        return new ResponseEntity<Labor>(HttpStatus.OK);
	    }*/
	

}
