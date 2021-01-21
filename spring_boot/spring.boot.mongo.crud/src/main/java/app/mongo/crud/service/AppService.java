package app.mongo.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.mongo.crud.model.Office;

@Service
public interface AppService {

	//Display all offices
	List<Office> listOffices();

	//Display one office
	Optional<Office> listOffice(String id);

	//Add an office
	Office addOffice(Office office);

	//Edit an office
	Office editOffice(Office office);

	//Delete an office
	void deleteOffice(String id);

	//Delete all offices
	void deleteOffices();
}
