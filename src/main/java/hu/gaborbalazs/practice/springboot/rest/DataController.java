package hu.gaborbalazs.practice.springboot.rest;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.gaborbalazs.practice.springboot.data.DataStoreProcessor;
import hu.gaborbalazs.practice.springboot.exception.BaseException;
import hu.gaborbalazs.practice.springboot.exception.ExceptionMessage;
import hu.gaborbalazs.practice.springboot.model.Data;

@RestController
public class DataController {

	@Autowired
	private Logger logger;

	@Autowired
	private DataStoreProcessor dataStoreProcessor;

	@RequestMapping("data")
	public List<Data> getDataStore() {
		try {
			return dataStoreProcessor.getAllData();
		} catch (IOException e) {
			logger.error(ExceptionMessage.ERR_FILE, e);
			throw new BaseException(ExceptionMessage.ERR_FILE);
		}
	}
}
