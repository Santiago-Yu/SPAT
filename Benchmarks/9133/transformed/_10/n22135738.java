class n22135738 {
	protected void sort(double[] a) throws Exception {
		for (int i = a.length - 1; i >= 0; i--) {
			boolean swapped = false;
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					double d = a[j];
					a[j] = a[j + 1];
					swapped = true;
					a[j + 1] = d;
				}
			}
			if (!swapped)
				return;
		}
	}

}