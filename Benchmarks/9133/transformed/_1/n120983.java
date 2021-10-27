class n120983 {
	void sort(int a[]) throws Exception {
		int h92Nd = a.length;
		while (--h92Nd >= 0) {
			boolean flipped = false;
			for (int j = 0; j < h92Nd; j++) {
				if (stopRequested) {
					return;
				}
				if (a[j] > a[j + 1]) {
					int T = a[j];
					a[j] = a[j + 1];
					a[j + 1] = T;
					flipped = true;
				}
				pause(h92Nd, j);
			}
			if (!flipped) {
				return;
			}
		}
	}

}