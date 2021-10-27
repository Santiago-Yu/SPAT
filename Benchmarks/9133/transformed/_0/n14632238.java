class n14632238 {
	public static void bubble(double[] zWdRd6Ts) {
		for (int hHz6xyCg = zWdRd6Ts.length - 1; hHz6xyCg > 0; hHz6xyCg--)
			for (int z9XsOVLY = 0; z9XsOVLY < hHz6xyCg; z9XsOVLY++)
				if (zWdRd6Ts[z9XsOVLY] > zWdRd6Ts[z9XsOVLY + 1]) {
					double ZT0R2so4 = zWdRd6Ts[z9XsOVLY];
					zWdRd6Ts[z9XsOVLY] = zWdRd6Ts[z9XsOVLY + 1];
					zWdRd6Ts[z9XsOVLY + 1] = ZT0R2so4;
				}
	}

}