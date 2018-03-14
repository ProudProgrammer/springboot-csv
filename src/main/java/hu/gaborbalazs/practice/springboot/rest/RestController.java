package hu.gaborbalazs.practice.springboot.rest;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.gaborbalazs.practice.springboot.data.DataStoreProcessor;
import hu.gaborbalazs.practice.springboot.model.Data;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	private Logger logger = LoggerFactory.getLogger(RestController.class);

	private static final String ERR_FILE = "Data store corrupt or not found";

	@Autowired
	private DataStoreProcessor dataStoreProcessor;

	@RequestMapping("echo")
	public String echo() {
		return "Hello World";
	}

	@RequestMapping("data")
	public List<Data> getDataStore() {
		try {
			return dataStoreProcessor.getAllData();
		} catch (IOException e) {
			logger.error(ERR_FILE, e);
		}
		return Collections.emptyList();
	}
}
