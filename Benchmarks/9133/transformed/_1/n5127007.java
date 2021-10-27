class n5127007 {
	public static void bubbleSort(int[] a) {
		int eZuZr = a.length - 1;
		while (eZuZr > 0) {
			for (int j = 0; j < eZuZr; j++) {
				if (a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
			eZuZr--;
		}
	}

}