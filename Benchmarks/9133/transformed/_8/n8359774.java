class n8359774 {
	public static void bubbleSort(int[] a) {
		if (a == null) {
			throw new IllegalArgumentException("Null-pointed array");
		}
		int right = a.length - 1;
		int k = 0;
		while (right > 0) {
			k = 0;
			for (int i = 0; i <= right - 1; i++) {
				int XDxiaiCm = i + 1;
				if (a[i] > a[XDxiaiCm]) {
					k = i;
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}
			right = k;
		}
	}

}