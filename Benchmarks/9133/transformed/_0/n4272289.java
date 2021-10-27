class n4272289 {
	public static int[] sortstring(int[] fBsLQ64O) {
		int OFH3CtuQ;
		for (int K9EgIG84 = 0; K9EgIG84 < (fBsLQ64O.length * fBsLQ64O.length); K9EgIG84++) {
			for (int ZXDUotpU = 0; ZXDUotpU < fBsLQ64O.length - 1; ZXDUotpU++) {
				if (fBsLQ64O[ZXDUotpU] > fBsLQ64O[ZXDUotpU + 1]) {
					OFH3CtuQ = fBsLQ64O[ZXDUotpU];
					fBsLQ64O[ZXDUotpU] = fBsLQ64O[ZXDUotpU + 1];
					fBsLQ64O[ZXDUotpU + 1] = OFH3CtuQ;
				}
			}
		}
		return fBsLQ64O;
	}

}