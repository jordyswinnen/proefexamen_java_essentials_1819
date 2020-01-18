package be.pxl.opgave.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Wedstrijd implements DatumVergelijkbaar {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/YY HH:mm");

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
			return team1.spelerIdKomtVoor(spelerId);
		} else {
			if (team2 != null) {
				return team2.spelerIdKomtVoor(spelerId);
			} else {
				return false;
			}
		}
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
		return wedstrijdDatum.until(datum, MINUTES);
	}

	@Override
	public String toString() {
		return "TEAM 1" + "\n"
				+ team1
				+ "TEAM 2" + "\n"
				+ team2
				+ wedstrijdDatum.format(FORMATTER) + "\n"
				+ "SCHEIDSRECHTER " + scheidrechter + "\n"
				+ "SCORE " + scoreTeam1 + " " + scoreTeam2;
		// Not sure how to determine if a game has started or not..
	}
}
