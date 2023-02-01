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

import com.technicaltest.technicaltest.entities.Perspective;
import com.technicaltest.technicaltest.services.PerspectiveService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/perspective")
public class PerspectiveResource {

	@Autowired
	public PerspectiveService perspectiveService;

	@GetMapping
	public ResponseEntity<List<Perspective>> findAll() {
		List<Perspective> list = perspectiveService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Perspective> insert(@RequestBody @Valid Perspective obj) {
		obj = perspectiveService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		perspectiveService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Perspective> update(@PathVariable Long id, @RequestBody Perspective obj){
		obj = perspectiveService.update(id,obj);
		return ResponseEntity.ok().body(obj);
	}

}
