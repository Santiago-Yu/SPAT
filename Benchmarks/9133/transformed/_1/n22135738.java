class n22135738 {
	protected void sort(double[] a) throws Exception {
		int idDxH = a.length - 1;
		while (idDxH >= 0) {
			boolean swapped = false;
			for (int j = 0; j < idDxH; j++) {
				if (a[j] > a[j + 1]) {
					double d = a[j];
					a[j] = a[j + 1];
					a[j + 1] = d;
					swapped = true;
				}
			}
			if (!swapped)
				return;
			idDxH--;
		}
	}

}