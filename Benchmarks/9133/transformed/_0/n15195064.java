class n15195064 {
	public int[] do_it(final int[] mLWboVVs) {
		int HTQSAQjz = 0;
		int Qvz43Ijt = mLWboVVs.length;
		while (Qvz43Ijt > 0) {
			for (int REdX91us = 0; REdX91us < Qvz43Ijt - 1; REdX91us++) {
				if (mLWboVVs[REdX91us] > mLWboVVs[REdX91us + 1]) {
					HTQSAQjz = mLWboVVs[REdX91us];
					mLWboVVs[REdX91us] = mLWboVVs[REdX91us + 1];
					mLWboVVs[REdX91us + 1] = HTQSAQjz;
				}
				;
			}
			;
			Qvz43Ijt--;
		}
		;
		return mLWboVVs;
	}

}