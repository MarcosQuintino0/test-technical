package com.technicaltest.technicaltest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicaltest.technicaltest.entities.StrategicPlan;
import com.technicaltest.technicaltest.repositories.StrategicPlanRepository;

@Service
public class StrategicPlanService {

	@Autowired
	public StrategicPlanRepository strategicPlanRepository;

	public List<StrategicPlan> findAll() {
		return strategicPlanRepository.findAll();
	}
	
	public StrategicPlan findById(Long id) {
		Optional<StrategicPlan> obj = strategicPlanRepository.findById(id);
		return obj.get();
	}

	public StrategicPlan insert(StrategicPlan obj) {
		return strategicPlanRepository.save(obj);
	}

	public void delete(Long id) {
		strategicPlanRepository.deleteById(id);
	}

	public StrategicPlan update(Long id, StrategicPlan obj) {

		StrategicPlan entity = strategicPlanRepository.getReferenceById(id);
		updateData(entity, obj);
		return strategicPlanRepository.save(entity);

	}

	private void updateData(StrategicPlan entity, StrategicPlan obj) {
		entity.setCompanyOrSector(obj.getCompanyOrSector());
		entity.setPlanDescription(obj.getPlanDescription());
		entity.setCompanyMission(obj.getCompanyMission());
		entity.setCompanyVision(obj.getCompanyVision());
	}

}
