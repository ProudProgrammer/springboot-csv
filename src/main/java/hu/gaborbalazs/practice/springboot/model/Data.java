package hu.gaborbalazs.practice.springboot.model;

import hu.gaborbalazs.practice.springboot.enums.DataStore;

public class Data {

	private String key;

	private String value;

	private DataStore type;

	public Data() {
	}

	public Data(String key, String value, DataStore type) {
		this.key = key;
		this.value = value;
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public DataStore getType() {
		return type;
	}

	public void setType(DataStore type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Data [key=" + key + ", value=" + value + ", type=" + type + "]";
	}

}
