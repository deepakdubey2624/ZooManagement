package com.zoomanagement.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.zoomanagement.springmvc.model.Type;

@Service("typeService")
public class TypeServiceImpl implements TypeService {
	
	
	

	@Override
	public List<Type> getAnimalTypeListForDropDown() {
		List<Type> animalTypeList = new ArrayList<>();
		animalTypeList.add(new Type(401,"Mammals"));
		animalTypeList.add(new Type(402,"Birds"));
		animalTypeList.add(new Type(403,"Reptiles"));
		
		return animalTypeList;
	}

}
