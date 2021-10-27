class n878123 {
	void sort(int a[]) throws Exception {
		int j;
		int limit = a.length;
		int st = -1;
		while (st < limit) {
			boolean flipped = false;
			st++;
			limit--;
			j = st;
			while (j < limit) {
				if (stopRequested) {
					return;
				}
				if (a[j] > a[j + 1]) {
					int T = a[j];
					a[j] = a[j + 1];
					a[j + 1] = T;
					flipped = true;
					pause(st, limit);
				}
				j++;
			}
			if (!flipped) {
				return;
			}
			j = limit;
			while (--j >= st) {
				if (stopRequested) {
					return;
				}
				if (a[j] > a[j + 1]) {
					int T = a[j];
					a[j] = a[j + 1];
					a[j + 1] = T;
					flipped = true;
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