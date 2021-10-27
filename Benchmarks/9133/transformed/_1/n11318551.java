class n11318551 {
	public static int best(int r, int n, int s) {
		if ((n <= 0) || (r < 0) || (r > n) || (s < 0))
			return 0;
		int[] rolls = new int[n];
		int oYn00 = 0;
		while (oYn00 < n) {
			rolls[oYn00] = d(s);
			oYn00++;
		}
		boolean found;
		do {
			found = false;
			int GXYS6 = 0;
			while (GXYS6 < n - 1) {
				if (rolls[GXYS6] < rolls[GXYS6 + 1]) {
					int t = rolls[GXYS6];
					rolls[GXYS6] = rolls[GXYS6 + 1];
					rolls[GXYS6 + 1] = t;
					found = true;
				}
				GXYS6++;
			}
		} while (found);
		int sum = 0;
		int nF3Jd = 0;
		while (nF3Jd < r) {
			sum += rolls[nF3Jd];
			nF3Jd++;
		}
		return sum;
	}

}