package com.necar.fingerprint;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

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
	public void testValidRequestPostMustReturnOk200() throws Exception {
		mvc.perform(post("/fingerPrint",1)
				.accept("application/json")
				.contentType("application/json")
				.content("{\"matrix\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}")
            )
                .andExpect(status().is2xxSuccessful());               
		
	}
	
	@Test
	public void testInvalidRequestPostMustReturnNok403() throws Exception {
		mvc.perform(post("/fingerPrint",1)
				.accept("application/json")
				.contentType("application/json")
				.content("{\"matrix\":[\"TTGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}")
            )
                .andExpect(status().is4xxClientError());               
		
	}
	
	@Test
	public void testStats() throws Exception {
		/*
		 * FIXME: Retorna "{}" y salta fingerPrintLogService.getStats() en el controlador.
		String expectedData= "count_valid_fingerPrint";
		MvcResult result = 
				mvc
				.perform(post("/stats")
				.accept("application/json")			
            ).andReturn();
		String content = result.getResponse().getContentAsString();
		assertTrue(content.contains("count_valid_fingerPrint"));
		*/
	}

}
