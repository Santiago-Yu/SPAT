class n13344290 {
	public static int best(int r, int n, int s) {
		if ((n <= 0) || (r < 0) || (r > n) || (s < 0))
			return 0;
		int[] rolls = new int[n];
		boolean found;
		for (int i = 0; i < n; i++)
			rolls[i] = d(s);
		int sum = 0;
		do {
			found = false;
			for (int x = 0; x < n - 1; x++) {
				if (rolls[x] < rolls[x + 1]) {
					int t = rolls[x];
					rolls[x] = rolls[x + 1];
					rolls[x + 1] = t;
					found = true;
				}
			}
		} while (found);
		for (int i = 0; i < r; i++)
			sum += rolls[i];
		return sum;
	}

}