class n15195064 {
	public int[] do_it(final int[] x) {
		int temp = 0;
		int j = x.length;
		while (j > 0) {
			int KjcNq = 0;
			while (KjcNq < j - 1) {
				if (x[KjcNq] > x[KjcNq + 1]) {
					temp = x[KjcNq];
					x[KjcNq] = x[KjcNq + 1];
					x[KjcNq + 1] = temp;
				}
				;
				KjcNq++;
			}
			;
			j--;
		}
		;
		return x;
	}

}