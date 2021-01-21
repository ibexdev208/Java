package app.mongo.crud.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import app.mongo.crud.exception.OfficeNotFoundException;
import app.mongo.crud.model.Office;
import app.mongo.crud.service.AppService;

@RestController
@RequestMapping("/api")
public class AppController {

	@Autowired
	AppService appService;

	//Get all offices
	@GetMapping(path="/offices")
	public List<Office> getOffices() {

		List<Office> offc = appService.listOffices();

		if(offc.isEmpty()) {
			throw new OfficeNotFoundException("The Database seems to be empty, add some data and try again!");
		}
		return appService.listOffices();
	}

	//Get a specific office
	@GetMapping(path="/office/{id}")
	public ResponseEntity<Office> getOffice(@PathVariable String id) {

		Office theId = appService.listOffice(id)
				.orElseThrow(() -> new OfficeNotFoundException("Check if the ID [" + id + "] is correct!"));

		return new ResponseEntity<>(theId, HttpStatus.OK);
	}

	//Add an office
	@PostMapping(path="/addOffice")
	public String newOffice(@Valid @RequestBody Office office) {

		appService.addOffice(office);

		return "'Newly created office has been added to the DB!'";
	}

	//Edit an office records
	@PutMapping(path="/edit/{id}")
	public ResponseEntity<Office> updateOffice(@Valid @PathVariable String id, @RequestBody Office office) {

		Office offc = appService.listOffice(id)
				.orElseThrow(() -> new OfficeNotFoundException("The ID [" + id + "] was not found"));

		offc.setContact(office.getContact());
		offc.setBuildingName(office.getBuildingName());
		offc.setAddress(office.getAddress());
		offc.setPostcode(office.getPostcode());
		offc.setCity(office.getCity());
		offc.setSize(office.getSize());
		offc.setTel(office.getTel());
		offc.setEmail(office.getEmail());

		return new ResponseEntity<>(appService.editOffice(offc), HttpStatus.OK);
	}

	//Delete a specific office
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<HttpStatus> deleteOffice(@PathVariable String id) {
		
		Office offc = appService.listOffice(id)
				.orElseThrow(() -> new OfficeNotFoundException("The ID [" + id + "] was not found"));
		
		appService.deleteOffice(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//Delete all offices
	@DeleteMapping(path="/deleteAll")
	public ResponseEntity<HttpStatus> deleteOffices() {
		
		List<Office> offc = appService.listOffices();

		if(offc.isEmpty()) {
			throw new OfficeNotFoundException("The Database seems to be empty, add some data and try again!");
		}else {
			
			appService.deleteOffices();
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
