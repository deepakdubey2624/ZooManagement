package com.zoomanagement.springmvc.model;

import java.util.ArrayList;
import java.util.List;

public class Area {
	
	private long id;
    private String areaName;
    private List<Pen> penList ;
    
    public Area(){
		id=0;
		penList = new ArrayList<Pen>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public List<Pen> getPenList() {
		return penList;
	}

	public void setPenList(List<Pen> penList) {
		this.penList = penList;
	}

	public Area(long id, String areaName, List<Pen> penList) {
		super();
		this.id = id;
		this.areaName = areaName;
		this.penList = penList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaName == null) ? 0 : areaName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((penList == null) ? 0 : penList.hashCode());
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
		Area other = (Area) obj;
		if (areaName == null) {
			if (other.areaName != null)
				return false;
		} else if (!areaName.equals(other.areaName))
			return false;
		if (id != other.id)
			return false;
		if (penList == null) {
			if (other.penList != null)
				return false;
		} else if (!penList.equals(other.penList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", areaName=" + areaName + ", penList=" + penList + "]";
	}
	

	
	
}
