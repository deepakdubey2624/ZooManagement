package com.zoomanagement.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.zoomanagement.springmvc.model.Pen;

@Service("penService")
public class PenServiceImpl implements PenService {
	
	 public static List<Pen> penList = new ArrayList<>();
	 private static final AtomicLong counter = new AtomicLong(100);
	 

	@Override
	public List<Pen> getPenListForDropDown() {
		 if (penList.size() < 1) { // if list blank populate these values in it

	            for (int k = 1; k <= 6; ++k) {
	            	Pen newCell = new Pen();
	                newCell.setId(counter.incrementAndGet());
	                newCell.setPenName("P" + k);
	             

	                penList.add(newCell);
	            }
	        }
	        return penList;
	}

}
