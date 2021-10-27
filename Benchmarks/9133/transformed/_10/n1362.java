class n1362 {
	public static int[] bubbleSort(int... a) {
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					int tmp = a[i];
					a[i] = a[i + 1];
					swapped = true;
					a[i + 1] = tmp;
					continue;
				}
			}
		} while (swapped);
		return a;
	}

}