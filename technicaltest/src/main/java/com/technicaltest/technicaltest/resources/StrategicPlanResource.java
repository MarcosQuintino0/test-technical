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

import com.technicaltest.technicaltest.entities.StrategicPlan;
import com.technicaltest.technicaltest.services.StrategicPlanService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/strategic")
public class StrategicPlanResource {

	@Autowired
	public StrategicPlanService strategicPlanService;

	@GetMapping
	public ResponseEntity<List<StrategicPlan>> findAll() {
		List<StrategicPlan> list = strategicPlanService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<StrategicPlan> insert(@RequestBody @Valid StrategicPlan obj) {
		obj = strategicPlanService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		strategicPlanService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<StrategicPlan> update(@PathVariable Long id, @RequestBody StrategicPlan obj){
		obj = strategicPlanService.update(id,obj);
		return ResponseEntity.ok().body(obj);
	}

}
