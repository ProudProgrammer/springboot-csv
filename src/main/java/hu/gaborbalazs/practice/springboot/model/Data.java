package hu.gaborbalazs.practice.springboot.model;

import hu.gaborbalazs.practice.springboot.enums.DataStore;

public class Data {

	private String key;
	private String value;
	private DataStore type;

	private Data(Builder builder) {
		this.key = builder.key;
		this.value = builder.value;
		this.type = builder.type;
	}

	public static Builder builder() {
		return new Builder();
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public DataStore getType() {
		return type;
	}

	public static class Builder {
		private String key;
		private String value;
		private DataStore type;

		public Builder key(String key) {
			this.key = key;
			return this;
		}

		public Builder value(String value) {
			this.value = value;
			return this;
		}

		public Builder type(DataStore type) {
			this.type = type;
			return this;
		}

		public Data build() {
			return new Data(this);
		}
	}

}
