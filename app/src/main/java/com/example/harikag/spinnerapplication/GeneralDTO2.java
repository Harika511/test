package com.example.harikag.spinnerapplication;

@SuppressWarnings("serial")
public class GeneralDTO2 implements java.io.Serializable {
	private int code;
	private String name;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {

		return this.code;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeneralDTO2 other = (GeneralDTO2) obj;
		if (code != other.code)
			return false;
		return true;
	}
}
