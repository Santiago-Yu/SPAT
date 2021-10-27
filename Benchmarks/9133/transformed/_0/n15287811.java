class n15287811 {
	public static int[] sort(int[] sd1lqnFD) {
		int Ihw5EVgj;
		int gwWgvdXg = sd1lqnFD.length;
		int[] nC7f5wvB = new int[gwWgvdXg];
		for (Ihw5EVgj = 0; Ihw5EVgj < gwWgvdXg; Ihw5EVgj++)
			nC7f5wvB[Ihw5EVgj] = Ihw5EVgj;
		int H2bILijb;
		boolean I8qHQ1ML = true;
		while (I8qHQ1ML) {
			I8qHQ1ML = false;
			for (Ihw5EVgj = 0; Ihw5EVgj < gwWgvdXg - 1; Ihw5EVgj++) {
				if (sd1lqnFD[nC7f5wvB[Ihw5EVgj]] > sd1lqnFD[nC7f5wvB[Ihw5EVgj + 1]]) {
					H2bILijb = nC7f5wvB[Ihw5EVgj];
					nC7f5wvB[Ihw5EVgj] = nC7f5wvB[Ihw5EVgj + 1];
					nC7f5wvB[Ihw5EVgj + 1] = H2bILijb;
					I8qHQ1ML = true;
				}
			}
		}
		return nC7f5wvB;
	}

}