package be.pxl.opgave;

// Final prevents inheritance
public final class Scheidsrechter extends Persoon {

	public Scheidsrechter(String id, String naam) {
		super(id, naam);
	}

	@Override
	public String toString() {
		// Calling this.sport will call the toString() method of the enum Sport

		return String.format("[%1s] %2s <ref>", getId(), getNaam());
	}
}
