package com.zoomanagement.springmvc.service;

import java.util.List;

import com.zoomanagement.springmvc.model.Area;
import com.zoomanagement.springmvc.model.Pen;


public interface AreaService {

	List<Area> getAreaListForDropDown(); 
	List<Pen> getPenListForDropDown(); 
	
}
