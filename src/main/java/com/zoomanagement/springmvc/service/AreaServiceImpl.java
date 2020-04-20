package com.zoomanagement.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.zoomanagement.springmvc.model.Area;
import com.zoomanagement.springmvc.model.Pen;

@Service("areaService")
public class AreaServiceImpl implements AreaService{
	
	 public static List<Area> areaList = new ArrayList<>();
	 private static final AtomicLong counter = new AtomicLong(200);
	 private static List<Pen> penList ;
	 private Random rand = new Random();
	
	@Override
	public List<Area> getAreaListForDropDown() {
		
		 if (areaList.size() < 1) { // if list blank populate these values in it

	            for (int k = 1; k <= 3; ++k) {
	            	Area newArea = new Area();
	            	newArea.setId(counter.incrementAndGet());
	            	newArea.setAreaName("A" + k);
	            	newArea.setPenList(getPenListForDropDown());
	            	

	                areaList.add(newArea);
	            }
	        }
	        return areaList;
	}
	
	

	@Override
	public List<Pen> getPenListForDropDown() {
		penList = new ArrayList<>();
		
		
		 if (penList.size() < 1) { // if list blank populate these values in it
			  
			
	            for (int k = 1; k <= 3; ++k) {
	            	
	            	Pen newPen = new Pen();
	            	int randomId = rand.nextInt(900)+100;
	            	newPen.setId(randomId);
	            	newPen.setPenName("P"+randomId);
	            
	                penList.add(newPen);
	            }
	        }
	        return penList;
	}
	
	

}
