package com.aya.jobtrackr.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceDefault implements ApplicationService {
	private final ApplicationRepository repo;
	
	public ApplicationServiceDefault(ApplicationRepository repo) {
		this.repo = repo;
	}
	
	//Create application
	public Application saveApplication(Application app) {
		return repo.save(app);
	}
	
	//Get app by id
	public Application getById(Long id) {
		Optional<Application> app = repo.findById(id);
		if(app.isPresent()) return app.get();
		else return null;
	}
	
	//Get all applications
	public List<Application> getAll(){
		return repo.findAll();
	}
	
	//DeleteApplication
	public void delete(Long id) {
		if(getById(id) != null) repo.deleteById(id);
	}
	
	public Application updateApplication(Application updated, Long id) {
		Application existing = getById(id) ;
		if(existing != null) {
			existing.setCompanyName(updated.getCompanyName());
			existing.setRoleTitle(updated.getRoleTitle());
			existing.setStatus(updated.getStatus());
			existing.setAppliedDate(updated.getAppliedDate());
			existing.setNotes(updated.getNotes());
			return saveApplication(existing);
		}
		else throw new RuntimeException("Application not found with id: " + id);
}
}
