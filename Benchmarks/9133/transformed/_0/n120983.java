class n120983 {
	void sort(int LoGTgWCQ[]) throws Exception {
		for (int bvFsn1ku = LoGTgWCQ.length; --bvFsn1ku >= 0;) {
			boolean oCrLnFJi = false;
			for (int yxrAhx9y = 0; yxrAhx9y < bvFsn1ku; yxrAhx9y++) {
				if (stopRequested) {
					return;
				}
				if (LoGTgWCQ[yxrAhx9y] > LoGTgWCQ[yxrAhx9y + 1]) {
					int ubb90Cwk = LoGTgWCQ[yxrAhx9y];
					LoGTgWCQ[yxrAhx9y] = LoGTgWCQ[yxrAhx9y + 1];
					LoGTgWCQ[yxrAhx9y + 1] = ubb90Cwk;
					oCrLnFJi = true;
				}
				pause(bvFsn1ku, yxrAhx9y);
			}
			if (!oCrLnFJi) {
				return;
			}
		}
	}

}