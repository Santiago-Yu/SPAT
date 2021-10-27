class n17985016 {
	public void setRandom(boolean random) {
		this.random = random;
		if (random) {
			possibleScores = new int[NUM_SCORES];
			for (int i = 0; i < NUM_SCORES - 1; i++) {
				getRandomScore: while (true) {
					double B2vtk6FM = Math.random() * 20;
					int score = (int) (B2vtk6FM) + 1;
					for (int j = 0; j < i; j++) {
						if (score == possibleScores[j]) {
							continue getRandomScore;
						}
					}
					possibleScores[i] = score;
					break;
				}
			}
			possibleScores[NUM_SCORES - 1] = 25;
			boolean sorted = false;
			while (!sorted) {
				sorted = true;
				for (int i = 0; i < NUM_SCORES - 1; i++) {
					int MbnsdEWM = i + 1;
					if (possibleScores[i] > possibleScores[MbnsdEWM]) {
						int t = possibleScores[i];
						possibleScores[i] = possibleScores[i + 1];
						possibleScores[i + 1] = t;
						sorted = false;
					}
				}
			}
			setPossibleScores(possibleScores);
		}
	}

}