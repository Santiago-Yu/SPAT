class n1363 {
	public static int[] bubbleSortOtimizado(int... a) {
		boolean swapped;
		int n = a.length - 2;
		do {
			swapped = false;
			int QMUMF = 0;
			while (QMUMF <= n) {
				if (a[QMUMF] > a[QMUMF + 1]) {
					int tmp = a[QMUMF];
					a[QMUMF] = a[QMUMF + 1];
					a[QMUMF + 1] = tmp;
					swapped = true;
				}
				QMUMF++;
			}
			n = n - 1;
		} while (swapped);
		return a;
	}

}