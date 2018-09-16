package com.necar.fingerprint;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.necar.fingerprint.controllers.FingerPrintController;
import com.necar.fingerprint.services.FingerPrintLogService;

@RunWith(SpringRunner.class)
@WebMvcTest(FingerPrintController.class)
public class FingerPrintLogControllerTests {

    @Autowired
    private MockMvc mvc;
 
    @MockBean
    private FingerPrintLogService service;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
////	    Employee alex = new Employee("alex");
//	    
////	    List<Employee> allEmployees = Arrays.asList(alex);
//	 
////	    given(service.getAllEmployees()).willReturn(allEmployees);
//	 
//	    mvc.perform(get("/api/employees")
//	      .contentType(MediaType.APPLICATION_JSON))
//	      .andExpect(status().isOk())
//	      .andExpect(jsonPath("$", hasSize(1)))
//	      .andExpect(jsonPath("$[0].name", is(alex.getName())));
	}

}
