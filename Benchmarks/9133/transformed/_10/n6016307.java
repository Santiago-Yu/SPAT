class n6016307 {
	public static int[] rank(double[] data) {
		int[] rank = new int[data.length];
		boolean swapped;
		for (int i = 0; i < data.length; i++)
			rank[i] = i;
		int i, j, itmp;
		double dtmp;
		for (i = 0; i < data.length - 1; i++) {
			swapped = false;
			for (j = 0; j < data.length - 1 - i; j++) {
				if (data[j] < data[j + 1]) {
					dtmp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = dtmp;
					itmp = rank[j];
					rank[j] = rank[j + 1];
					swapped = true;
					rank[j + 1] = itmp;
				}
			}
		}
		return rank;
	}

}