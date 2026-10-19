package com.aya.jobtrackr.application;

import java.util.List;

public interface ApplicationService {
	public Application saveApplication(Application app);
	public Application getById(Long id);
	public List<Application> getAll();
	public void delete(Long id);
	public Application updateApplication(Application updated, Long id);
}
