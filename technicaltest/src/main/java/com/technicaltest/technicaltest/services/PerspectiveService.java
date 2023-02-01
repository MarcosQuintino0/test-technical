package com.technicaltest.technicaltest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicaltest.technicaltest.entities.Perspective;
import com.technicaltest.technicaltest.repositories.PerspectiveRepository;

@Service
public class PerspectiveService {

	@Autowired
	public PerspectiveRepository perspectiveRepository;

	public List<Perspective> findAll() {
		return perspectiveRepository.findAll();
	}

	public Perspective insert(Perspective obj) {
		return perspectiveRepository.save(obj);
	}

	public void delete(Long id) {
		perspectiveRepository.deleteById(id);
	}

	public Perspective update(Long id, Perspective obj) {

		Perspective entity = perspectiveRepository.getReferenceById(id);
		updateData(entity, obj);
		return perspectiveRepository.save(entity);

	}

	private void updateData(Perspective entity, Perspective obj) {
		//codar
	}

}
