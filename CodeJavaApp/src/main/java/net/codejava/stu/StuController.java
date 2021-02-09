package net.codejava.stu;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuController {

	@Autowired
	private Stu_Service stu_service;
	
	@PostMapping("/stu1")
	public stu saveStu(@RequestBody stu s) {
		return stu_service.save_Student(s);
	}
	
	@GetMapping("/stu2")
	public List<stu> listAll(){
		return stu_service.listAll();
	}

	
	@GetMapping("/stu3/{id}")
	public ResponseEntity<stu> get(@PathVariable Integer id) {
	    try {
	    	
	    	stu product = stu_service.get(id);
	        return new ResponseEntity<stu>(product, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<stu>(HttpStatus.NOT_FOUND);
	    }      
	}

	@PutMapping("/stu4/{id}")
	public ResponseEntity<stu> update(@RequestBody stu s, @PathVariable Integer id) {
	    try {
	    	stu existProduct = stu_service.get(id);
	    	stu_service.save_Student(s);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/stu5/{id}")
	public void delete(@PathVariable Integer id) {
		stu_service.delete(id);
	}
	
	
}
