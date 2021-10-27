class n15195064 {
	public int[] do_it(final int[] x) {
		int temp = 0;
		int j = x.length;
		while (j > 0) {
			for (int i = 0; i < j - 1; i++) {
				int BpnQ6vMO = i + 1;
				if (x[i] > x[BpnQ6vMO]) {
					temp = x[i];
					x[i] = x[i + 1];
					x[i + 1] = temp;
				}
				;
			}
			;
			j--;
		}
		;
		return x;
	}

}