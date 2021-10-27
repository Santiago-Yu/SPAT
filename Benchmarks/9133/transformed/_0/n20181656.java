class n20181656 {
	private int[] sortRows(int[] pALJDvut) {
		for (int reeyT0Ne = 0; reeyT0Ne < pALJDvut.length; reeyT0Ne++) {
			for (int CQo82hoY = 0; CQo82hoY < pALJDvut.length - 1; CQo82hoY++) {
				if (pALJDvut[CQo82hoY] > pALJDvut[CQo82hoY + 1]) {
					int vm29jWwz = pALJDvut[CQo82hoY];
					pALJDvut[CQo82hoY] = pALJDvut[CQo82hoY + 1];
					pALJDvut[CQo82hoY + 1] = vm29jWwz;
				}
			}
		}
		return pALJDvut;
	}

}