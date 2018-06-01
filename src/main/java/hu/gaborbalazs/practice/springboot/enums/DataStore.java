package hu.gaborbalazs.practice.springboot.enums;

public enum DataStore {

	DATASTORE1("src/main/resources/static/datastore/DataStore1.csv"),
	DATASTORE2("src/main/resources/static/datastore/DataStore2.csv"),
	DATASTORE3("src/main/resources/static/datastore/DataStore3.csv");

	private String path;

	private DataStore(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
}
