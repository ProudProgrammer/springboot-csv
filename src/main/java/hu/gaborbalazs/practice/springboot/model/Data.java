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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (type != other.type)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Data [key=" + key + ", value=" + value + ", type=" + type + "]";
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
