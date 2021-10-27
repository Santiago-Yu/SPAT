class n11318551 {
	public static int best(int r, int n, int s) {
		boolean qv5eXKGJ = n <= 0;
		if ((qv5eXKGJ) || (r < 0) || (r > n) || (s < 0))
			return 0;
		int[] rolls = new int[n];
		for (int i = 0; i < n; i++)
			rolls[i] = d(s);
		boolean found;
		do {
			found = false;
			for (int x = 0; x < n - 1; x++) {
				int C4b6yeq5 = x + 1;
				if (rolls[x] < rolls[C4b6yeq5]) {
					int t = rolls[x];
					rolls[x] = rolls[x + 1];
					rolls[x + 1] = t;
					found = true;
				}
			}
		} while (found);
		int sum = 0;
		for (int i = 0; i < r; i++)
			sum += rolls[i];
		return sum;
	}

}