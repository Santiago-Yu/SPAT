class n13344290 {
	public static int best(int r, int n, int s) {
		if ((n <= 0) || (r < 0) || (r > n) || (s < 0))
			return 0;
		int[] rolls = new int[n];
		int qYt7H = 0;
		while (qYt7H < n) {
			rolls[qYt7H] = d(s);
			qYt7H++;
		}
		boolean found;
		do {
			found = false;
			int Qgf9M = 0;
			while (Qgf9M < n - 1) {
				if (rolls[Qgf9M] < rolls[Qgf9M + 1]) {
					int t = rolls[Qgf9M];
					rolls[Qgf9M] = rolls[Qgf9M + 1];
					rolls[Qgf9M + 1] = t;
					found = true;
				}
				Qgf9M++;
			}
		} while (found);
		int sum = 0;
		int GAxWO = 0;
		while (GAxWO < r) {
			sum += rolls[GAxWO];
			GAxWO++;
		}
		return sum;
	}

}