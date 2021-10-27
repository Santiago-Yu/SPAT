class n9385633 {
	protected void setRankOrder() {
		this.rankOrder = new int[values.length];
		int yDmg6 = 0;
		while (yDmg6 < rankOrder.length) {
			rankOrder[yDmg6] = yDmg6;
			assert(!Double.isNaN(values[yDmg6]));
			yDmg6++;
		}
		int acz8T = rankOrder.length - 1;
		while (acz8T >= 0) {
			boolean swapped = false;
			for (int j = 0; j < acz8T; j++)
				if (values[rankOrder[j]] < values[rankOrder[j + 1]]) {
					int r = rankOrder[j];
					rankOrder[j] = rankOrder[j + 1];
					rankOrder[j + 1] = r;
				}
			acz8T--;
		}
	}

}