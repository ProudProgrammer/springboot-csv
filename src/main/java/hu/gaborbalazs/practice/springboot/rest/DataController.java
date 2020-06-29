package hu.gaborbalazs.practice.springboot.rest;

import hu.gaborbalazs.practice.springboot.data.DataStoreProcessor;
import hu.gaborbalazs.practice.springboot.exception.BaseException;
import hu.gaborbalazs.practice.springboot.exception.ExceptionType;
import hu.gaborbalazs.practice.springboot.model.Data;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class DataController {

    @Autowired
    private Logger logger;

    @Autowired
    private DataStoreProcessor dataStoreProcessor;

    @RequestMapping("data")
    public List<Data> getDataStore() {
        try {
            return dataStoreProcessor.getAllDataFromDataStores();
        } catch (IOException e) {
            logger.error(ExceptionType.DATA_STORE_CORRUPT.getExceptionMessage(), e);
            throw new BaseException(ExceptionType.DATA_STORE_CORRUPT);
        }
    }
}
