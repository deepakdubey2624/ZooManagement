package com.zoomanagement.springmvc.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zoomanagement.springmvc.configuration.CORSFilter;
import com.zoomanagement.springmvc.model.Animal;
import com.zoomanagement.springmvc.service.AnimalService;


public class ZooRestControllerTest {

//	 private static final int UNKNOWN_ID = Integer.MAX_VALUE;

	    private MockMvc mockMvc;

	    @Mock
	    private AnimalService animalService;

	    @InjectMocks
	    private ZooRestController zooRestController;
	    @InjectMocks
	    private IndexController indexController;

	    @Before
	    public void init(){
	        MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders
	                .standaloneSetup(indexController,zooRestController)
	                .addFilters(new CORSFilter())
	                .build();
	    }

	    
	    // =========================================== Get All Users ==========================================

	    @Test
	    public void test_get_all_success() throws Exception {
	        List<Animal> animals = Arrays.asList(
	                 new Animal(1,"Lion", "Mammals", 1,3,"P1","A1"),
	                 new Animal(4,"Ostriches", "Birds", 5,6,"P2","A2"),
	                  new Animal(7,"Snake", "Reptiles", 8,9,"P3","A3"));

	        when(animalService.findAllAnimals()).thenReturn(animals);

	        mockMvc.perform(get("/animals"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

	        verify(animalService, times(1)).findAllAnimals();
	        verifyNoMoreInteractions(animalService);
	    }


	     
	    public static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	
}
