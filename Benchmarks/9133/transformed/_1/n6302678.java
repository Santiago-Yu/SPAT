class n6302678 {
	public ISpieler[] sortiereSpielerRamsch(ISpieler[] spieler) {
		int HvLio = 0;
		while (HvLio < spieler.length) {
			for (int j = 0; j < spieler.length - 1; j++) {
				if (werteAugen(spieler[j].getStiche()) > werteAugen(spieler[j + 1].getStiche())) {
					ISpieler a = spieler[j];
					spieler[j] = spieler[j + 1];
					spieler[j + 1] = a;
				}
			}
			HvLio++;
		}
		return spieler;
	}

}