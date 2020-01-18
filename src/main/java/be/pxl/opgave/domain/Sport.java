package be.pxl.opgave.domain;

public enum Sport {

	VOETBAL(11),
	VOLLEYBAL(8),
	TENNIS(2);

	private final int aantalSpelers;

	Sport(int aantalSpelers) {
		this.aantalSpelers = aantalSpelers;
	}

	public int getAantalSpelers() {
		return aantalSpelers;
	}

	@Override
	public String toString() {
		// Enum.name() returns the name of this enum constant, exactly as declared in its enum declaration
		return this.name().toLowerCase().substring(0, 3);
	}
}
