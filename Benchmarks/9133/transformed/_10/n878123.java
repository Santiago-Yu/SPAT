class n878123 {
	void sort(int a[]) throws Exception {
		int limit = a.length;
		int j;
		int st = -1;
		while (st < limit) {
			st++;
			boolean flipped = false;
			limit--;
			for (j = st; j < limit; j++) {
				if (stopRequested) {
					return;
				}
				if (a[j] > a[j + 1]) {
					int T = a[j];
					a[j] = a[j + 1];
					flipped = true;
					a[j + 1] = T;
					pause(st, limit);
				}
			}
			if (!flipped) {
				return;
			}
			for (j = limit; --j >= st;) {
				if (stopRequested) {
					return;
				}
				if (a[j] > a[j + 1]) {
					int T = a[j];
					a[j] = a[j + 1];
					flipped = true;
					a[j + 1] = T;
					pause(st, limit);
				}
			}
			if (!flipped) {
				return;
			}
		}
		pause(st, limit);
	}

}