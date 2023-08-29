package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.consult;
import com.example.demo.repository.consultRepo;
import com.example.demo.response.response;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/consult/")
public class consultcontroller {

	@Autowired
	private consultRepo consultRepository;

	// create users rest api
	@PostMapping("/saveconsult")
	public consult createUsers(@RequestBody consult consult) {
		return consultRepository.save(consult);
	}

	// get all Users rest api
	@GetMapping("/getconsult")
	private List<consult> getAllConsult() {
		return consultRepository.findAll();
	}

	// get User by Id rest api
	@GetMapping("/getconsult/{id}")
	public ResponseEntity<consult> getconsultById(@PathVariable Long id) {
		consult consult = consultRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Consult not exist with id : " + id));
		return ResponseEntity.ok(consult);
	}

	// update User rest api
	@PutMapping("/getconsult/{id}")
	public ResponseEntity<consult> updateConsult(@PathVariable Long id, @RequestBody consult consult) {
		consult consult2 = consultRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Consult not exist with id : " + id));
		consult.setName(consult2.getName());
		consult.setEmail(consult2.getEmail());
		consult.setAvailable_dates(consult2.getAvailable_dates());
		consult.setTime_slot(consult2.getTime_slot());
		consult.setNic(consult2.getNic());

		consult updateConsult = consultRepository.save(consult);
		return ResponseEntity.ok(updateConsult);
	}

	// delete User rest api
	@DeleteMapping("/getconsult/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteConsult(@PathVariable Long id) {
		consult consult = consultRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Consult not exist with id : " + id));

		consultRepository.delete(consult);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	// Users Login
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody consult loginForm) {
		String name = loginForm.getName();
		String password = loginForm.getPassword();

		consult consults = consultRepository.findByEmailAndPassword(name, password);
		if (consults != null) {
			// User authenticated successfully
			return response.responseBuilder("Consult Login Successfully.", HttpStatus.OK,
					consultRepository.findByEmailAndPassword(name, password));

		} else {
			// Invalid credentials
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("message", "Request Consult Not Found");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
		}
	}

}
