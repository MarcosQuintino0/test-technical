package com.technicaltest.technicaltest.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "strategic_plan")
public class StrategicPlan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "planning_horizon")
	private Integer planningHorizon;

	@Column(name = "company_or_sector")
	private String companyOrSector;

	@Column(name = "plan_description")
	private String planDescription;

	@Column(name = "company_mission")
	private String companyMission;

	@Column(name = "company_vision")
	private String companyVision;

	private List<String> companyValues;
	
	@OneToMany(mappedBy = "strategicPlan")
	private List<Perspective> perspectiveList = new ArrayList<>();
	
	private List<String> dadList;

	public StrategicPlan() {

	}

	public StrategicPlan(Long id, Integer planningHorizon, String companyOrSector, String planDescription,
			String companyMission, String companyVision, List<String> companyValues, List<Perspective> perspectiveList,
			List<String> dadList) {
		this.id = id;
		this.planningHorizon = planningHorizon;
		this.companyOrSector = companyOrSector;
		this.planDescription = planDescription;
		this.companyMission = companyMission;
		this.companyVision = companyVision;
		this.companyValues = companyValues;
		this.perspectiveList = perspectiveList;
		this.dadList = dadList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPlanningHorizon() {
		return planningHorizon;
	}

	public void setPlanningHorizon(Integer planningHorizon) {
		this.planningHorizon = planningHorizon;
	}

	public String getCompanyOrSector() {
		return companyOrSector;
	}

	public void setCompanyOrSector(String companyOrSector) {
		this.companyOrSector = companyOrSector;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public String getCompanyMission() {
		return companyMission;
	}

	public void setCompanyMission(String companyMission) {
		this.companyMission = companyMission;
	}

	public String getCompanyVision() {
		return companyVision;
	}

	public void setCompanyVision(String companyVision) {
		this.companyVision = companyVision;
	}

	public List<String> getCompanyValues() {
		return companyValues;
	}

	public void setCompanyValues(List<String> companyValues) {
		this.companyValues = companyValues;
	}

	public List<Perspective> getPerspectiveList() {
		return perspectiveList;
	}

	public void setPerspectiveList(List<Perspective> perspectiveList) {
		this.perspectiveList = perspectiveList;
	}

	public List<String> getDadList() {
		return dadList;
	}

	public void setDadList(List<String> dadList) {
		this.dadList = dadList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StrategicPlan other = (StrategicPlan) obj;
		return Objects.equals(id, other.id);
	}

}
