package hu.gaborbalazs.practice.springboot.data;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import hu.gaborbalazs.practice.springboot.enums.DataStore;
import hu.gaborbalazs.practice.springboot.model.Data;

@Component
public class DataStoreProcessor {

	public List<Data> getAllDataFromDataStores() throws IOException {
		List<Data> datas = new ArrayList<>();
		for (DataStore dataStore : DataStore.values()) {
			datas.addAll(csvToData(new InputStreamReader(new ClassPathResource(dataStore.getPath()).getInputStream()),
					dataStore));
		}
		sortDataByValueThenIfEqualsByKey(datas);
		return datas;
	}

	private List<Data> csvToData(Reader reader, DataStore dataStore) throws IOException {
		List<Data> datas = new ArrayList<>();
		try (CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT)) {
			parser.getRecords().forEach(record -> datas
					.add(Data.builder().key(record.get(0)).value(record.get(1).toUpperCase()).type(dataStore).build()));
		}
		return datas;
	}

	private List<Data> sortDataByValueThenIfEqualsByKey(List<Data> datas) {
		Collections.sort(datas, (data1, data2) -> {
			Comparator<Data> c = Comparator.comparing(Data::getValue);
			c = c.thenComparing(Data::getKey);
			return c.compare(data1, data2);
		});
		return datas;
	}
}
