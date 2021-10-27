class n17985016 {
	public void setRandom(boolean CH9yaKTc) {
		this.random = CH9yaKTc;
		if (CH9yaKTc) {
			possibleScores = new int[NUM_SCORES];
			for (int VnQhlDAr = 0; VnQhlDAr < NUM_SCORES - 1; VnQhlDAr++) {
				getRandomScore: while (true) {
					int SLKFdERZ = (int) (Math.random() * 20) + 1;
					for (int vWFgtbr2 = 0; vWFgtbr2 < VnQhlDAr; vWFgtbr2++) {
						if (SLKFdERZ == possibleScores[vWFgtbr2]) {
							continue getRandomScore;
						}
					}
					possibleScores[VnQhlDAr] = SLKFdERZ;
					break;
				}
			}
			possibleScores[NUM_SCORES - 1] = 25;
			boolean Qoe02Mln = false;
			while (!Qoe02Mln) {
				Qoe02Mln = true;
				for (int c5jkg7I8 = 0; c5jkg7I8 < NUM_SCORES - 1; c5jkg7I8++) {
					if (possibleScores[c5jkg7I8] > possibleScores[c5jkg7I8 + 1]) {
						int SLmHCNSs = possibleScores[c5jkg7I8];
						possibleScores[c5jkg7I8] = possibleScores[c5jkg7I8 + 1];
						possibleScores[c5jkg7I8 + 1] = SLmHCNSs;
						Qoe02Mln = false;
					}
				}
			}
			setPossibleScores(possibleScores);
		}
	}

}