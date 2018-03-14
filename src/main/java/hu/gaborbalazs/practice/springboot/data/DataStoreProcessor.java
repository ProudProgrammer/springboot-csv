package hu.gaborbalazs.practice.springboot.data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import hu.gaborbalazs.practice.springboot.enums.DataStoreType;
import hu.gaborbalazs.practice.springboot.model.Data;

@Component
public class DataStoreProcessor {

    @Value("${datastore1}")
    private String ds1Path;

    @Value("${datastore2}")
    private String ds2Path;

    @Value("${datastore3}")
    private String ds3Path;

    private File file1;

    private File file2;

    private File file3;

    @PostConstruct
    public void init() {
        file1 = new File(ds1Path);
        file2 = new File(ds2Path);
        file3 = new File(ds3Path);
    }

    public List<Data> getAllData() throws IOException {
        List<Data> datas = new ArrayList<>();
        datas.addAll(csvToData(file1, DataStoreType.DATASTORE1));
        datas.addAll(csvToData(file2, DataStoreType.DATASTORE2));
        datas.addAll(csvToData(file3, DataStoreType.DATASTORE3));
        Collections.sort(datas, (data1, data2) -> {
            Comparator<Data> c = Comparator.comparing(Data::getValue);
            c = c.thenComparing(Data::getKey);
            return c.compare(data1, data2);
        });
        return datas;
    }

    private List<Data> csvToData(File file, DataStoreType type) throws IOException {
        List<Data> datas = new ArrayList<>();
        try (CSVParser parser = new CSVParser(new FileReader(file), CSVFormat.DEFAULT)) {
            parser.getRecords()
                    .forEach(record -> datas.add(new Data(record.get(0), record.get(1).toUpperCase(), type)));
        }
        return datas;
    }
}
