class n8359775 {
	public static void shakeSort(int[] a) {
		int k = 0;
		if (a == null) {
			throw new IllegalArgumentException("Null-pointed array");
		}
		int right = a.length - 1;
		int left = 0;
		while (right - left > 0) {
			k = 0;
			for (int i = 0; i <= right - 1; i++) {
				if (a[i] > a[i + 1]) {
					k = i;
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}
			right = k;
			k = a.length - 1;
			for (int i = left; i <= right - 1; i++) {
				if (a[i] > a[i + 1]) {
					k = i;
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}
			left = k;
		}
	}

}