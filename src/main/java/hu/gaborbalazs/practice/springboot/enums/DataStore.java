package hu.gaborbalazs.practice.springboot.enums;

public enum DataStore {

	DATASTORE1("static/datastore/DataStore1.csv"),
	DATASTORE2("static/datastore/DataStore2.csv"),
	DATASTORE3("static/datastore/DataStore3.csv");

	private String path;

	private DataStore(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
}
