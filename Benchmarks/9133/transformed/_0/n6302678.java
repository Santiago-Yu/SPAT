class n6302678 {
	public ISpieler[] sortiereSpielerRamsch(ISpieler[] Se2N81eA) {
		for (int h5rkdLwZ = 0; h5rkdLwZ < Se2N81eA.length; h5rkdLwZ++) {
			for (int TRDx55wd = 0; TRDx55wd < Se2N81eA.length - 1; TRDx55wd++) {
				if (werteAugen(Se2N81eA[TRDx55wd].getStiche()) > werteAugen(Se2N81eA[TRDx55wd + 1].getStiche())) {
					ISpieler p9Sy4nO6 = Se2N81eA[TRDx55wd];
					Se2N81eA[TRDx55wd] = Se2N81eA[TRDx55wd + 1];
					Se2N81eA[TRDx55wd + 1] = p9Sy4nO6;
				}
			}
		}
		return Se2N81eA;
	}

}