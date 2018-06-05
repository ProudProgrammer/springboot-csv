package hu.gaborbalazs.practice.springboot;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import hu.gaborbalazs.practice.springboot.data.DataStoreProcessor;
import hu.gaborbalazs.practice.springboot.enums.DataStore;
import hu.gaborbalazs.practice.springboot.model.Data;

public class DataStoreProcessorTest {

	private DataStoreProcessor underTest;

	@Before
	public void setUp() {
		underTest = new DataStoreProcessor();
	}

	@Test
	public void testGetAllDataFromDataStores() throws IOException {
		List<Data> actual = underTest.getAllDataFromDataStores();
		List<Data> expected = new ArrayList<>();
		for (DataStore dataStore : DataStore.values()) {
			try (CSVParser parser = new CSVParser(
					new InputStreamReader(new ClassPathResource(dataStore.getPath()).getInputStream()),
					CSVFormat.DEFAULT)) {
				parser.getRecords().forEach(record -> expected.add(
						Data.builder().key(record.get(0)).value(record.get(1).toUpperCase()).type(dataStore).build()));
			}
		}
		Collections.sort(expected, (data1, data2) -> {
			Comparator<Data> c = Comparator.comparing(Data::getValue);
			c = c.thenComparing(Data::getKey);
			return c.compare(data1, data2);
		});
		assertEquals(expected.size(), actual.size());
		for (int i = 0; i < expected.size(); i++) {
			assertEquals(expected.get(i).getKey(), actual.get(i).getKey());
			assertEquals(expected.get(i).getValue(), actual.get(i).getValue());
			assertEquals(expected.get(i).getType(), actual.get(i).getType());
		}
	}
}
