package com.app.modulos.Controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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

import com.app.modulos.Entity.Labor;
import com.app.modulos.Entity.Usuario;
import com.app.modulos.Services.ServiciosUsuario;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins ="http://localhost:4200")//ACCESO DESDE CUALQUIER URL
public class UsuarioController {
	
	
	
	@Autowired
	ServiciosUsuario serviceUsers;
	
	 @GetMapping("/lista")
	  public ResponseEntity<List<Usuario>> list(){
	       List<Usuario> list = serviceUsers.list();
	       return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	    }

	    @GetMapping("/detalles/{id}")
	    public ResponseEntity<Usuario> getById(@PathVariable("id") int id){
	        if(!serviceUsers.existsById(id))
	            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
	        Usuario user = serviceUsers.getOne(id).get();
	        return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	    }

	    @GetMapping("/detallesforName/{nombre}")
	    public ResponseEntity<Usuario> getByNombre(@PathVariable("nombre") String nombre){
	        if(!serviceUsers.existsByNombre(nombre))
	            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
	        Usuario user = serviceUsers.getByNombre(nombre).get();
	        return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	    }

	   /* @PostMapping("/create")
	    public ResponseEntity<?> create(@RequestBody DtoPersona dtop){
	    	System.out.println(dtop.getNombre() +"-----"+dtop.getCorreo());
	        if(StringUtils .isBlank(dtop.getNombre()))
	            return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST);
	        if(StringUtils .isBlank(dtop.getCorreo()))
	            return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST);
	        if(serviceUsers.existsByNombre(dtop.getCorreo()))
	            return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST);
	        if(dtop.getCelular()==0 || dtop.getCelular()<0)
	        	return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST);
	        
	        //Usuario people = new Usuario(dtop.getNombre(),dtop.getCelular(),dtop.getCorreo(),dtop);
	                                    //(String nombre, int celular, String correo, Labor trabajo)
	        serviceUsers.save(people);
	        return new ResponseEntity<Usuario>(people,HttpStatus.OK) ;
	    }*/
	    @PostMapping("/add")
		public ResponseEntity<Usuario> Add(@RequestBody Usuario people ){//cuando cada json se va registrar el objeto se vuelve json y viseversa		
			
			 System.out.println(people.getNombre());		
			 serviceUsers.save(people);
		     return new ResponseEntity<Usuario>(people,HttpStatus.OK) ;
		}
        
	    @PutMapping("/update/{id}")
	    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody Usuario dtop){
	        if(!serviceUsers.existsById(id))
	            return new ResponseEntity<Labor>(HttpStatus.NOT_FOUND);
	        if(serviceUsers.existsByNombre(dtop.getCorreo()) && serviceUsers.getByNombre(dtop.getCorreo()).get().getId() != id)
	            return new ResponseEntity<Labor>(HttpStatus.BAD_REQUEST);
	        if(StringUtils.isBlank(dtop.getCorreo()))
	            return new ResponseEntity<Labor>(HttpStatus.BAD_REQUEST);

	        Usuario people = serviceUsers.getOne(id).get();
	        people.setNombre(dtop.getNombre());
	        people.setCelular(dtop.getCelular());
	        people.setCorreo(dtop.getCorreo());
	        people.setTrabajo(dtop.getTrabajo());
	        serviceUsers.save(people);
	        return new ResponseEntity<Usuario>(people,HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> delete(@PathVariable("id")int id){
	    	
	        if(!serviceUsers.existsById(id))
	            return new ResponseEntity<Labor>(HttpStatus.NOT_FOUND);
	        serviceUsers.delete(id);
	        return new ResponseEntity<Labor>(HttpStatus.OK);
	    }

}
