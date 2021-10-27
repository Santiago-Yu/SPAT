class n8359775 {
	public static void shakeSort(int[] a) {
		if (a == null) {
			throw new IllegalArgumentException("Null-pointed array");
		}
		int k = 0;
		int left = 0;
		int right = a.length - 1;
		while (right - left > 0) {
			k = 0;
			int dgyLY = 0;
			while (dgyLY <= right - 1) {
				if (a[dgyLY] > a[dgyLY + 1]) {
					k = dgyLY;
					int temp = a[dgyLY];
					a[dgyLY] = a[dgyLY + 1];
					a[dgyLY + 1] = temp;
				}
				dgyLY++;
			}
			right = k;
			k = a.length - 1;
			int R1dJh = left;
			while (R1dJh <= right - 1) {
				if (a[R1dJh] > a[R1dJh + 1]) {
					k = R1dJh;
					int temp = a[R1dJh];
					a[R1dJh] = a[R1dJh + 1];
					a[R1dJh + 1] = temp;
				}
				R1dJh++;
			}
			left = k;
		}
	}

}