package be.pxl.opgave;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Wedstrijd implements DatumVergelijkbaar {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/YY HH:mm");
	;

	private LocalDateTime wedstrijdDatum;
	private Team team1;
	private Team team2;
	private Scheidsrechter scheidrechter;
	private int scoreTeam1;
	private int scoreTeam2;

	public Wedstrijd(Team team1, Team team2, Scheidsrechter scheidrechter, int dag, int maand, int jaar, int uur, int minute) {
		this.wedstrijdDatum = LocalDateTime.of(jaar, maand, dag, uur, minute);
		this.team1 = team1;
		this.team2 = team2;
		this.scheidrechter = scheidrechter;
	}

	public boolean spelerIdKomtVoor(String spelerId) {
		if (team1 != null) {
			if (!team1.spelerIdKomtVoor(spelerId)) {
				if (team2 != null) {
					return team1.spelerIdKomtVoor(spelerId);
				} else {
					return true;
				}
			}
		} else {
			return true;
		}

		return false;
	}

	public void setScore(int scoreTeam1, int scoreTeam2) {
		this.scoreTeam1 = scoreTeam1;
		this.scoreTeam2 = scoreTeam2;
	}

	public LocalDateTime getWedstrijdDatum() {
		return wedstrijdDatum;
	}

	@Override
	public long berekenAantalMinutenNa(LocalDateTime datum) {
		return wedstrijdDatum.until(datum, ChronoUnit.MINUTES);
	}

	@Override
	public String toString() {
		return "TEAM 1" + "\n"
				+ team1.toString()
				+ "TEAM 2" + "\n"
				+ team2.toString()
				+ wedstrijdDatum.format(FORMATTER) + "\n"
				+ "SCHEIDSRECHTER " + scheidrechter.toString() + "\n"
				+ "SCORE " + scoreTeam1 + " " + scoreTeam2;
	}
}
