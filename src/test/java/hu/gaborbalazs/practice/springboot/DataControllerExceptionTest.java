package hu.gaborbalazs.practice.springboot;

import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import hu.gaborbalazs.practice.springboot.aspect.RestResponseEntityExceptionHandler;
import hu.gaborbalazs.practice.springboot.data.DataStoreProcessor;
import hu.gaborbalazs.practice.springboot.rest.DataController;

@RunWith(MockitoJUnitRunner.class)
public class DataControllerExceptionTest {

	private MockMvc mvc;

	@Mock
	private DataStoreProcessor dataStoreProcessor;

	@Mock
	private Logger logger;

	@Mock
	private RestResponseEntityExceptionHandler exceptionHandler;

	@InjectMocks
	private DataController controller;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(controller).setControllerAdvice(exceptionHandler).build();
	}

	@Test
	public void testGetDataWithException() throws Exception {
		when(dataStoreProcessor.getAllDataFromDataStores()).thenThrow(IOException.class);
		mvc.perform(MockMvcRequestBuilders.get("/data").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is5xxServerError());
	}
}
