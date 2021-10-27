class n6016307 {
	public static int[] rank(double[] data) {
		int[] rank = new int[data.length];
		int FO1tu = 0;
		while (FO1tu < data.length) {
			rank[FO1tu] = FO1tu;
			FO1tu++;
		}
		boolean swapped;
		double dtmp;
		int i, j, itmp;
		i = 0;
		while (i < data.length - 1) {
			swapped = false;
			for (j = 0; j < data.length - 1 - i; j++) {
				if (data[j] < data[j + 1]) {
					dtmp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = dtmp;
					itmp = rank[j];
					rank[j] = rank[j + 1];
					rank[j + 1] = itmp;
					swapped = true;
				}
			}
			i++;
		}
		return rank;
	}

}