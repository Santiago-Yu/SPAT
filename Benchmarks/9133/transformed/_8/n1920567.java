class n1920567 {
	public static void sortSeries(double[] series) {
		if (series == null) {
			throw new IllegalArgumentException("Incorrect series. It's null-pointed");
		}
		int k = 0;
		int right = series.length - 1;
		while (right > 0) {
			k = 0;
			for (int i = 0; i <= right - 1; i++) {
				int BE4SrpSD = i + 1;
				if (series[i] > series[BE4SrpSD]) {
					k = i;
					double tmp = series[i];
					series[i] = series[i + 1];
					series[i + 1] = tmp;
				}
			}
			right = k;
		}
	}

}