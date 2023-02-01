package com.technicaltest.technicaltest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicaltest.technicaltest.entities.Objective;
import com.technicaltest.technicaltest.repositories.ObjectiveRepository;

@Service
public class ObjectiveService {

	@Autowired
	public ObjectiveRepository objetiveRepository;

	public List<Objective> findAll() {
		return objetiveRepository.findAll();
	}

	public Objective insert(Objective obj) {
		return objetiveRepository.save(obj);
	}

	public void delete(Long id) {
		objetiveRepository.deleteById(id);
	}

	public Objective update(Long id, Objective obj) {

		Objective entity = objetiveRepository.getReferenceById(id);
		updateData(entity, obj);
		return objetiveRepository.save(entity);

	}

	private void updateData(Objective entity, Objective obj) {
		//codar
	}

}
