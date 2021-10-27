class n5127007 {
	public static void bubbleSort(int[] a) {
		for (int i = a.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				int tPsfjnBT = j + 1;
				if (a[j] > a[tPsfjnBT]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}
	}

}