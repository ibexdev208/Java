package app.mongo.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.mongo.crud.model.Office;
import app.mongo.crud.repository.AppRepository;

@Service
public class AppServiceImpl implements AppService{

	@Autowired
	AppRepository appRepository;
	
	@Override
	public List<Office> listOffices() {
		return appRepository.findAll();
	}
	
	@Override
	public Optional<Office> listOffice(String id) {
		return appRepository.findById(id);
	}

	@Override
	public Office addOffice(Office office) {
		return appRepository.insert(office);
	}

	@Override
	public Office editOffice(Office office) {
		return appRepository.save(office);
	}

	@Override
	public void deleteOffice(String id) {
		appRepository.deleteById(id);
	}

	@Override
	public void deleteOffices() {
		appRepository.deleteAll();
		
	}
}
