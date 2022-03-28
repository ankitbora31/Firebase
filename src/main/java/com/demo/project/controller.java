package com.demo.project;

import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
	public crudService cservice;
	
	public controller(crudService cservice) {
		this.cservice = cservice;
	}
	
	@PostMapping("/create")
	public String createCrud(@RequestBody crud cr) throws InterruptedException, ExecutionException{
		return cservice.createCrud(cr);
	}
	
	@GetMapping("/get")
	public crud getCrud(@RequestParam String documentId) throws InterruptedException, ExecutionException {
		return cservice.getCrud(documentId);
	}
	
	@PutMapping("/update")
	public String updateCrud(@RequestBody crud cr) throws InterruptedException, ExecutionException {
		return cservice.updateCrud(cr);
	}
	
	@DeleteMapping("/delete")
	public String deleteCrud(@RequestParam String documentId) throws InterruptedException, ExecutionException {
		return cservice.deleteCrud(documentId);
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> testGetEndpoint(){return ResponseEntity.ok("Test get endpoint is working");}
}
