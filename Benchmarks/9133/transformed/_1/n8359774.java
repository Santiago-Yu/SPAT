class n8359774 {
	public static void bubbleSort(int[] a) {
		if (a == null) {
			throw new IllegalArgumentException("Null-pointed array");
		}
		int right = a.length - 1;
		int k = 0;
		while (right > 0) {
			k = 0;
			int td4Yd = 0;
			while (td4Yd <= right - 1) {
				if (a[td4Yd] > a[td4Yd + 1]) {
					k = td4Yd;
					int temp = a[td4Yd];
					a[td4Yd] = a[td4Yd + 1];
					a[td4Yd + 1] = temp;
				}
				td4Yd++;
			}
			right = k;
		}
	}

}