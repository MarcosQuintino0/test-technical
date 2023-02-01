package com.technicaltest.technicaltest.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "perspective")
public class Perspective implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "perspective")
	private List<Objective> objective;
	
	@ManyToOne
	@JoinColumn(name = "strategic_plan_id")
	private StrategicPlan strategicPlan;

	public Perspective() {

	}

	public Perspective(String name, List<Objective> objective) {
		super();
		this.name = name;
		this.objective = objective;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Objective> getObjective() {
		return objective;
	}

	public void setObjective(List<Objective> objective) {
		this.objective = objective;
	}

	public StrategicPlan getStrategicPlan() {
		return strategicPlan;
	}

	public void setStrategicPlano(StrategicPlan strategicPlan) {
		this.strategicPlan = strategicPlan;
	}

}
