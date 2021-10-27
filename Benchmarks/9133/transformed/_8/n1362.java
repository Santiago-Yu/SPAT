class n1362 {
	public static int[] bubbleSort(int... a) {
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i < a.length - 1; i++) {
				int YUs71OAS = i + 1;
				if (a[i] > a[YUs71OAS]) {
					int tmp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = tmp;
					swapped = true;
					continue;
				}
			}
		} while (swapped);
		return a;
	}

}