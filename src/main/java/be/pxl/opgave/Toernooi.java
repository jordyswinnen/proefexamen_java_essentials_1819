package be.pxl.opgave;

import java.time.LocalDateTime;

public class Toernooi {

	private static final int MAX_AANTAL_WEDSTRIJDEN = 10;

	private Wedstrijd[] wedstrijden;

	public Toernooi() {
		wedstrijden = new Wedstrijd[MAX_AANTAL_WEDSTRIJDEN];
	}

	public void voegWedstrijdToe(Wedstrijd wedstrijd) {
		int vrijePositieIndex = vindVrijePositie();

		if (vrijePositieIndex != -1) {
			wedstrijden[vrijePositieIndex] = wedstrijd;

			return;
		}

		System.err.println("Geen ruimte meer voor wedstrijden’");
	}

	private int vindVrijePositie() {
		for (int i = 0, wedstrijdenLength = wedstrijden.length; i < wedstrijdenLength; i++) {
			if (wedstrijden[i] == null) {
				return i;
			}
		}

		return -1;
	}

	public LocalDateTime zoekDatumVolgendeWedstrijdVan(String spelerId) {
		for (int i = 0, wedstrijdenLength = wedstrijden.length; i < wedstrijdenLength; i++) {
			if (wedstrijden[i] != null && wedstrijden[i].spelerIdKomtVoor(spelerId)) {
				return wedstrijden[i].getWedstrijdDatum();
			}
		}
		return null;
	}
}