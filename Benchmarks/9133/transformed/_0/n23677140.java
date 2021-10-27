class n23677140 {
	public static void BubbleSortLong2(long[] bD9s5ADD) {
		int MDg8jipv;
		int RH1zjvwb = bD9s5ADD.length - 1;
		do {
			MDg8jipv = 0;
			for (int RXk2s22d = 0; RXk2s22d < bD9s5ADD.length - 1; RXk2s22d++) {
				if (bD9s5ADD[RXk2s22d] > bD9s5ADD[RXk2s22d + 1]) {
					long y6Wb3CQw = bD9s5ADD[RXk2s22d];
					bD9s5ADD[RXk2s22d] = bD9s5ADD[RXk2s22d + 1];
					bD9s5ADD[RXk2s22d + 1] = y6Wb3CQw;
					MDg8jipv = RXk2s22d;
				}
			}
			RH1zjvwb = MDg8jipv;
		} while (RH1zjvwb > 0);
	}

}