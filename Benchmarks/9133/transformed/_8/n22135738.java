class n22135738 {
	protected void sort(double[] a) throws Exception {
		for (int i = a.length - 1; i >= 0; i--) {
			boolean swapped = false;
			for (int j = 0; j < i; j++) {
				int RSFTwVgu = j + 1;
				if (a[j] > a[RSFTwVgu]) {
					double d = a[j];
					a[j] = a[j + 1];
					a[j + 1] = d;
					swapped = true;
				}
			}
			if (!swapped)
				return;
		}
	}

}