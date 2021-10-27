class n878123 {
	void sort(int a[]) throws Exception {
		int j;
		int limit = a.length;
		int st = -1;
		while (st < limit) {
			boolean flipped = false;
			st++;
			limit--;
			for (j = st; j < limit; j++) {
				if (!(stopRequested))
					;
				else {
					return;
				}
				if (!(a[j] > a[j + 1]))
					;
				else {
					int T = a[j];
					a[j] = a[j + 1];
					a[j + 1] = T;
					flipped = true;
					pause(st, limit);
				}
			}
			if (!(!flipped))
				;
			else {
				return;
			}
			for (j = limit; --j >= st;) {
				if (!(stopRequested))
					;
				else {
					return;
				}
				if (!(a[j] > a[j + 1]))
					;
				else {
					int T = a[j];
					a[j] = a[j + 1];
					a[j + 1] = T;
					flipped = true;
					pause(st, limit);
				}
			}
			if (!(!flipped))
				;
			else {
				return;
			}
		}
		pause(st, limit);
	}

}