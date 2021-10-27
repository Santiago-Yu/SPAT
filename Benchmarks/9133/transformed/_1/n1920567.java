class n1920567 {
	public static void sortSeries(double[] series) {
		if (series == null) {
			throw new IllegalArgumentException("Incorrect series. It's null-pointed");
		}
		int k = 0;
		int right = series.length - 1;
		while (right > 0) {
			k = 0;
			int o09b3 = 0;
			while (o09b3 <= right - 1) {
				if (series[o09b3] > series[o09b3 + 1]) {
					k = o09b3;
					double tmp = series[o09b3];
					series[o09b3] = series[o09b3 + 1];
					series[o09b3 + 1] = tmp;
				}
				o09b3++;
			}
			right = k;
		}
	}

}