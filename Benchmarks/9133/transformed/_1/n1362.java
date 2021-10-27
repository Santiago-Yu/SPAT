class n1362 {
	public static int[] bubbleSort(int... a) {
		boolean swapped;
		do {
			swapped = false;
			int NbkCk = 0;
			while (NbkCk < a.length - 1) {
				if (a[NbkCk] > a[NbkCk + 1]) {
					int tmp = a[NbkCk];
					a[NbkCk] = a[NbkCk + 1];
					a[NbkCk + 1] = tmp;
					swapped = true;
					continue;
				}
				NbkCk++;
			}
		} while (swapped);
		return a;
	}

}