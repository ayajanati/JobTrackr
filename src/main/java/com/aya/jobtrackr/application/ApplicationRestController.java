package com.aya.jobtrackr.application;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applications")
public class ApplicationRestController {
	private final ApplicationService service;
	
	public ApplicationRestController(ApplicationService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Application> create(@RequestBody Application application){
		Application app = service.saveApplication(application);
		
		if(app != null) return ResponseEntity.status(HttpStatus.CREATED).body(app);
		else return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@GetMapping
	public List<Application> getAll(){
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Application> getApplication(@PathVariable Long id) {
		 Application app = service.getById(id);
		if(app != null) return ResponseEntity.ok().body(app);
		else return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public Application update(@RequestBody Application app, @PathVariable Long id ) {
		return service.updateApplication(app, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
