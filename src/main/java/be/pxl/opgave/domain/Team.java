package be.pxl.opgave.domain;

public class Team {

	private Sport sport;
	private Speler[] spelers;

	public Team(Sport sport) {
		this.sport = sport;
		this.spelers = new Speler[sport.getAantalSpelers()];
	}

	public void voegSpelerToe(Speler speler) {
		if (!spelerKomtVoor(speler) && speler.getSport().equals(this.sport)) {
			int vrijePositieIndex = vindVrijePositie();

			if (vrijePositieIndex != -1) {
				spelers[vrijePositieIndex] = speler;

				return;
			}
		}


		System.out.println("Foutieve ingave");
	}

	private int vindVrijePositie() {
		for (int i = 0, spelersLength = spelers.length; i < spelersLength; i++) {
			if (spelers[i] == null) {
				return i;
			}
		}

		return -1;
	}

	private boolean spelerKomtVoor(Speler speler) {
		return spelerIdKomtVoor(speler.getId());
	}

	public boolean spelerIdKomtVoor(String spelerId) {
		for (Speler spelerInTeam : spelers) {
			if (new Speler(spelerId).equals(spelerInTeam)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		int vrijePositie = vindVrijePositie();

		if (vrijePositie == -1) {
			StringBuilder spelersStringBuilder = new StringBuilder();

			for (Speler speler : spelers) {
				spelersStringBuilder
						.append(speler.toString())
						.append("\n");
			}

			return spelersStringBuilder.toString();
		} else {
			return "Onvolledig team";
		}
	}
}
