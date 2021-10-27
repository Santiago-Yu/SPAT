class n14632238 {
	public static void bubble(double[] a) {
		int cEYZg = a.length - 1;
		while (cEYZg > 0) {
			for (int j = 0; j < cEYZg; j++)
				if (a[j] > a[j + 1]) {
					double temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			cEYZg--;
		}
	}

}