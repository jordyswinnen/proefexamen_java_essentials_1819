package be.pxl.opgave.domain;

// Final prevents inheritance
public final class Scheidsrechter extends Persoon {

	public Scheidsrechter(String id, String naam) {
		super(id, naam);
	}

	@Override
	public String toString() {
		return String.format("[%1s] %2s <ref>", getId(), getNaam());
	}
}
