package hu.gaborbalazs.practice.springboot;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import hu.gaborbalazs.practice.springboot.aspect.RestResponseEntityExceptionHandler;
import hu.gaborbalazs.practice.springboot.data.DataStoreProcessor;
import hu.gaborbalazs.practice.springboot.exception.ExceptionType;
import hu.gaborbalazs.practice.springboot.rest.DataController;

@RunWith(MockitoJUnitRunner.class)
public class DataControllerNegativeTest {

	private MockMvc mvc;

	@Mock
	private DataStoreProcessor dataStoreProcessor;

	@Mock
	private Logger logger;

	@InjectMocks
	private DataController controller;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(controller).setControllerAdvice(new RestResponseEntityExceptionHandler())
				.build();
	}

	@Test
	public void testGetDataWithException() throws Exception {
		when(dataStoreProcessor.getAllDataFromDataStores()).thenThrow(IOException.class);
		mvc.perform(MockMvcRequestBuilders.get("/data").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is5xxServerError())
				.andExpect(content().json("{'exceptionType':'" + ExceptionType.DATA_STORE_CORRUPT + "'}"));
	}
}
