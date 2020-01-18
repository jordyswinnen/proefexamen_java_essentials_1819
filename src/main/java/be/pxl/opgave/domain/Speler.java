package be.pxl.opgave.domain;

public class Speler extends Persoon {

	private Sport sport;

	public Speler(String id, String naam, Sport sport) {
		super(id, naam);

		this.sport = sport;
	}

	public Speler(String id) {
		super(id, "");

		this.sport = null;
	}

	public Sport getSport() {
		return sport;
	}

	@Override
	public String toString() {
		// Calling this.sport will call the toString() method of the enum Sport

		return String.format("[%s] %s (%s)", this.getId(), this.getNaam(), sport);
	}
}