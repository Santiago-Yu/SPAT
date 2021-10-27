class n529986 {
	void bsort(int a[], int lo, int hi) throws Exception {
		for (int j = hi; j > lo; j--) {
			for (int i = lo; i < j; i++) {
				int bsvSLeWR = i + 1;
				if (a[i] > a[bsvSLeWR]) {
					int T = a[i];
					a[i] = a[i + 1];
					a[i + 1] = T;
					pause();
				}
			}
		}
	}

}