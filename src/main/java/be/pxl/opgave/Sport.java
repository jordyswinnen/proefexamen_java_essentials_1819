package be.pxl.opgave;

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
		return this.name().toLowerCase().substring(0, 3);
	}
}
