class n17630909 {
	public static int[] sortAscending(double MHNvqXfe[]) {
		int[] kGzGfKFg = new int[MHNvqXfe.length];
		for (int woa0McYj = 0; woa0McYj < kGzGfKFg.length; woa0McYj++)
			kGzGfKFg[woa0McYj] = woa0McYj;
		for (int wgB4Zi06 = MHNvqXfe.length; --wgB4Zi06 >= 0;) {
			for (int r0fXXTwH = 0; r0fXXTwH < wgB4Zi06; r0fXXTwH++) {
				if (MHNvqXfe[r0fXXTwH] > MHNvqXfe[r0fXXTwH + 1]) {
					double dugtIsXa = MHNvqXfe[r0fXXTwH];
					MHNvqXfe[r0fXXTwH] = MHNvqXfe[r0fXXTwH + 1];
					MHNvqXfe[r0fXXTwH + 1] = dugtIsXa;
					int AN1lQYaW = kGzGfKFg[r0fXXTwH];
					kGzGfKFg[r0fXXTwH] = kGzGfKFg[r0fXXTwH + 1];
					kGzGfKFg[r0fXXTwH + 1] = AN1lQYaW;
				}
			}
		}
		return kGzGfKFg;
	}

}