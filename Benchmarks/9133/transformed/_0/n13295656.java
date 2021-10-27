class n13295656 {
	public static int[] BubbleSortDEC(int[] vJpUApFu) {
		boolean jYxlJ8PL = true;
		int aacb6ILs;
		int[] AIdRLV3y = new int[vJpUApFu.length];
		for (int TjFbyO0n = 0; TjFbyO0n < vJpUApFu.length; TjFbyO0n++) {
			AIdRLV3y[TjFbyO0n] = TjFbyO0n;
		}
		while (jYxlJ8PL) {
			jYxlJ8PL = false;
			for (int XOS3Ln3q = 0; XOS3Ln3q < vJpUApFu.length - 1; XOS3Ln3q++) {
				if (vJpUApFu[XOS3Ln3q] < vJpUApFu[XOS3Ln3q + 1]) {
					aacb6ILs = vJpUApFu[XOS3Ln3q];
					vJpUApFu[XOS3Ln3q] = vJpUApFu[XOS3Ln3q + 1];
					vJpUApFu[XOS3Ln3q + 1] = aacb6ILs;
					aacb6ILs = AIdRLV3y[XOS3Ln3q];
					AIdRLV3y[XOS3Ln3q] = AIdRLV3y[XOS3Ln3q + 1];
					AIdRLV3y[XOS3Ln3q + 1] = aacb6ILs;
					jYxlJ8PL = true;
				}
			}
		}
		return (AIdRLV3y);
	}

}