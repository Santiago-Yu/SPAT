class n245162 {
	static void sort(int[] a) {
		int i = 0;
		for (; i < a.length - 1;) {
			int j = 0;
			while (j < (a.length - i) - 1) {
				if (a[j] > a[j + 1]) {
					int aux = a[j];
					a[j] = a[j + 1];
					a[j + 1] = aux;
				}
				j = j + 1;
			}
			i = i + 1;
		}
	}

}