package hu.gaborbalazs.practice.springboot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
		expected.add(Data.builder().key("9").value("B").type(DataStore.DATASTORE1).build());
		expected.add(Data.builder().key("1").value("D").type(DataStore.DATASTORE3).build());
		expected.add(Data.builder().key("22").value("E").type(DataStore.DATASTORE3).build());
		expected.add(Data.builder().key("12").value("F").type(DataStore.DATASTORE3).build());
		expected.add(Data.builder().key("10").value("G").type(DataStore.DATASTORE3).build());
		expected.add(Data.builder().key("18").value("G").type(DataStore.DATASTORE2).build());
		expected.add(Data.builder().key("3").value("M").type(DataStore.DATASTORE1).build());
		expected.add(Data.builder().key("24").value("P").type(DataStore.DATASTORE2).build());
		expected.add(Data.builder().key("25").value("Q").type(DataStore.DATASTORE2).build());
		expected.add(Data.builder().key("13").value("T").type(DataStore.DATASTORE3).build());
		expected.add(Data.builder().key("20").value("U").type(DataStore.DATASTORE2).build());
		expected.add(Data.builder().key("7").value("V").type(DataStore.DATASTORE1).build());
		expected.add(Data.builder().key("19").value("W").type(DataStore.DATASTORE2).build());
		expected.add(Data.builder().key("5").value("X").type(DataStore.DATASTORE1).build());
		expected.add(Data.builder().key("76").value("Y").type(DataStore.DATASTORE1).build());
		Assert.assertEquals(expected, actual);
	}
}
