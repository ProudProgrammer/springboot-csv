package hu.gaborbalazs.practice.springboot.data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Component;

import hu.gaborbalazs.practice.springboot.enums.DataStore;
import hu.gaborbalazs.practice.springboot.model.Data;

@Component
public class DataStoreProcessor {

	public List<Data> getAllData() throws IOException {
		List<Data> datas = new ArrayList<>();
		for (DataStore dataStore : DataStore.values()) {
			datas.addAll(csvToData(new File(dataStore.getPath()), dataStore));
		}
		Collections.sort(datas, (data1, data2) -> {
			Comparator<Data> c = Comparator.comparing(Data::getValue);
			c = c.thenComparing(Data::getKey);
			return c.compare(data1, data2);
		});
		return datas;
	}

	private List<Data> csvToData(File file, DataStore dataStore) throws IOException {
		List<Data> datas = new ArrayList<>();
		try (CSVParser parser = new CSVParser(new FileReader(file), CSVFormat.DEFAULT)) {
			parser.getRecords()
					.forEach(record -> datas.add(new Data(record.get(0), record.get(1).toUpperCase(), dataStore)));
		}
		return datas;
	}
}
