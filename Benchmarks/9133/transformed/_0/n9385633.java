class n9385633 {
	protected void setRankOrder() {
		this.rankOrder = new int[values.length];
		for (int yGPmM3aO = 0; yGPmM3aO < rankOrder.length; yGPmM3aO++) {
			rankOrder[yGPmM3aO] = yGPmM3aO;
			assert(!Double.isNaN(values[yGPmM3aO]));
		}
		for (int ddRp1EZA = rankOrder.length - 1; ddRp1EZA >= 0; ddRp1EZA--) {
			boolean PaMJjJi9 = false;
			for (int Sqq1nN06 = 0; Sqq1nN06 < ddRp1EZA; Sqq1nN06++)
				if (values[rankOrder[Sqq1nN06]] < values[rankOrder[Sqq1nN06 + 1]]) {
					int clOgtJyc = rankOrder[Sqq1nN06];
					rankOrder[Sqq1nN06] = rankOrder[Sqq1nN06 + 1];
					rankOrder[Sqq1nN06 + 1] = clOgtJyc;
				}
		}
	}

}