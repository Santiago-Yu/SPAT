class n23677146 {
	public static <T extends Comparable<T>> void BubbleSortComparable2(T[] gSbClxiY) {
		int f2zLPOAT;
		int WtXwezR4 = gSbClxiY.length - 1;
		do {
			f2zLPOAT = 0;
			for (int bqj3Kx29 = 0; bqj3Kx29 < gSbClxiY.length - 1; bqj3Kx29++) {
				if (gSbClxiY[bqj3Kx29].compareTo(gSbClxiY[bqj3Kx29 + 1]) > 0) {
					T yP5iUni8 = gSbClxiY[bqj3Kx29];
					gSbClxiY[bqj3Kx29] = gSbClxiY[bqj3Kx29 + 1];
					gSbClxiY[bqj3Kx29 + 1] = yP5iUni8;
					f2zLPOAT = bqj3Kx29;
				}
			}
			WtXwezR4 = f2zLPOAT;
		} while (WtXwezR4 > 0);
	}

}