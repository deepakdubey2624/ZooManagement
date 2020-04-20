package com.zoomanagement.springmvc.model;

import java.util.List;

public class Animal {

//	Behavior behavior; 
	public long id;
	
	public String name;
	
	public String animalType;
	
	public long penId;
	
	public long areaId;
    
	public String penName;
	
	public String areaName;
	
//	public abstract List<? extends Animal> display();
	
	
	public Animal(){
		id=0;
		penId=0;
		areaId=0;
	}
    
//	public boolean canFly(Animal animal) {
//		return behavior.canfly(animal);
//	}
	
    public Animal(long id, String name, String animalType, long penId, long areaId, String penName, String areaName) {
		super();
		this.id = id;
		this.name = name;
		this.animalType = animalType;
		this.penId = penId;
		this.areaId = areaId;
		this.penName = penName;
		this.areaName = areaName;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", animalType=" + animalType + ", penId=" + penId + ", areaId="
				+ areaId + ", penName=" + penName + ", areaName=" + areaName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animalType == null) ? 0 : animalType.hashCode());
		result = prime * result + (int) (areaId ^ (areaId >>> 32));
		result = prime * result + ((areaName == null) ? 0 : areaName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (penId ^ (penId >>> 32));
		result = prime * result + ((penName == null) ? 0 : penName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (animalType == null) {
			if (other.animalType != null)
				return false;
		} else if (!animalType.equals(other.animalType))
			return false;
		if (areaId != other.areaId)
			return false;
		if (areaName == null) {
			if (other.areaName != null)
				return false;
		} else if (!areaName.equals(other.areaName))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (penId != other.penId)
			return false;
		if (penName == null) {
			if (other.penName != null)
				return false;
		} else if (!penName.equals(other.penName))
			return false;
		return true;
	}

	
    
    public String getPenName() {
		return penName;
	}

	public void setPenName(String penName) {
		this.penName = penName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}



    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public long getPenId() {
		return penId;
	}

	public void setPenId(long penId) {
		this.penId = penId;
	}

	public long getAreaId() {
		return areaId;
	}

	public void setAreaId(long areaId) {
		this.areaId = areaId;
	}

	
	

	
}
