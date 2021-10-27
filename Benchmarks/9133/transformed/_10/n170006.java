class n170006 {
	void bubbleSort(int[] a) {
		int j = a.length - 1;
		int i = 0;
		int stop = 0;
		int aux = 0;
		while (stop == 0) {
			i = 0;
			stop = 1;
			while (i < j) {
				if (a[i] > a[i + 1]) {
					aux = a[i];
					a[i] = a[i + 1];
					stop = 0;
					a[i + 1] = aux;
				}
				i = i + 1;
			}
			j = j - 1;
		}
	}

}