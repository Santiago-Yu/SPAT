class n1363 {
	public static int[] bubbleSortOtimizado(int... a) {
		int n = a.length - 2;
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i <= n; i++) {
				if (a[i] > a[i + 1]) {
					int tmp = a[i];
					a[i] = a[i + 1];
					swapped = true;
					a[i + 1] = tmp;
				}
			}
			n = n - 1;
		} while (swapped);
		return a;
	}

}