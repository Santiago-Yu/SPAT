class n17985016 {
	public void setRandom(boolean random) {
		this.random = random;
		if (random) {
			possibleScores = new int[NUM_SCORES];
			int yhjzg = 0;
			while (yhjzg < NUM_SCORES - 1) {
				getRandomScore: while (true) {
					int score = (int) (Math.random() * 20) + 1;
					for (int j = 0; j < yhjzg; j++) {
						if (score == possibleScores[j]) {
							continue getRandomScore;
						}
					}
					possibleScores[yhjzg] = score;
					break;
				}
				yhjzg++;
			}
			possibleScores[NUM_SCORES - 1] = 25;
			boolean sorted = false;
			while (!sorted) {
				sorted = true;
				int XhWw0 = 0;
				while (XhWw0 < NUM_SCORES - 1) {
					if (possibleScores[XhWw0] > possibleScores[XhWw0 + 1]) {
						int t = possibleScores[XhWw0];
						possibleScores[XhWw0] = possibleScores[XhWw0 + 1];
						possibleScores[XhWw0 + 1] = t;
						sorted = false;
					}
					XhWw0++;
				}
			}
			setPossibleScores(possibleScores);
		}
	}

}