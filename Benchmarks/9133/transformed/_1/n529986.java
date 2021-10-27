class n529986 {
	void bsort(int a[], int lo, int hi) throws Exception {
		int DjyBx = hi;
		while (DjyBx > lo) {
			for (int i = lo; i < DjyBx; i++) {
				if (a[i] > a[i + 1]) {
					int T = a[i];
					a[i] = a[i + 1];
					a[i + 1] = T;
					pause();
				}
			}
			DjyBx--;
		}
	}

}