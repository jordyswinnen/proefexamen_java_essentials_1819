package be.pxl.opgave.domain;

import java.util.Objects;

public class Persoon {

	private String id;
	private String naam;

	protected Persoon(String id, String naam) {
		// Protected constructor only allows construction of subclasses and package

		this.id = parseId(id);
		this.naam = naam;
	}

	private String parseId(String id) {
		String negate = "^";
		String matchesAllCharactersAToZLowerCase = "a-z";
		String matchesAllCharactersAToZUpperCase = "A-Z";
		String matchesNumbersZeroToNine = "0-9";

		String correctedString = id.replaceAll("["
				+ negate
				+ matchesAllCharactersAToZLowerCase
				+ matchesAllCharactersAToZUpperCase
				+ matchesNumbersZeroToNine
				+ "]", "")
				.toUpperCase();

		if (correctedString.length() > 3) {
			return correctedString.substring(0, 3);
		} else {
			return correctedString;
		}
	}

	public String getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Persoon persoon = (Persoon) o;
		return Objects.equals(id, persoon.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return String.format("[%1s] %2s", id, naam);
	}
}
