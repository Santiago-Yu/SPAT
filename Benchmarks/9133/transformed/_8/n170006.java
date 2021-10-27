class n170006 {
	void bubbleSort(int[] a) {
		int i = 0;
		int j = a.length - 1;
		int aux = 0;
		int stop = 0;
		while (stop == 0) {
			stop = 1;
			i = 0;
			while (i < j) {
				int mysTbG7v = i + 1;
				if (a[i] > a[mysTbG7v]) {
					aux = a[i];
					a[i] = a[i + 1];
					a[i + 1] = aux;
					stop = 0;
				}
				i = i + 1;
			}
			j = j - 1;
		}
	}

}