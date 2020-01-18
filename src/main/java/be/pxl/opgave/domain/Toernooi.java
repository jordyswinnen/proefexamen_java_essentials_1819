package be.pxl.opgave.domain;

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

		System.out.println("Geen ruimte meer voor wedstrijden’");
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
		// This might be an error in the exam. Logic to get the first possible date (next upcoming game) should be inverted i think?
		LocalDateTime minDate = LocalDateTime.MIN;

		for (Wedstrijd wedstrijd : wedstrijden) {
			if (wedstrijd != null && wedstrijd.spelerIdKomtVoor(spelerId) && minDate.isBefore(wedstrijd.getWedstrijdDatum())) {
				minDate = wedstrijd.getWedstrijdDatum();
			}
		}
		return minDate == LocalDateTime.MIN ? null : minDate;
	}
}