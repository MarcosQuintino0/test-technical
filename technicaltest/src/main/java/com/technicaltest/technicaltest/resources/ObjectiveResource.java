package com.technicaltest.technicaltest.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.technicaltest.technicaltest.entities.Objective;
import com.technicaltest.technicaltest.services.ObjectiveService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/objective")
public class ObjectiveResource {

	@Autowired
	public ObjectiveService objectiveService;

	@GetMapping
	public ResponseEntity<List<Objective>> findAll() {
		List<Objective> list = objectiveService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Objective> insert(@RequestBody @Valid Objective obj) {
		obj = objectiveService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		objectiveService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Objective> update(@PathVariable Long id, @RequestBody Objective obj){
		obj = objectiveService.update(id,obj);
		return ResponseEntity.ok().body(obj);
	}

}
