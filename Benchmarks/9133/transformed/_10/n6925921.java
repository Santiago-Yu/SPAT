class n6925921 {
	public static void bubbleSort(int[] polje) {
		int temp;
		boolean swapped;
		int n = polje.length;
		do {
			n--;
			swapped = false;
			for (int i = 0; i < n - 1; i++) {
				if (polje[i] > polje[i + 1]) {
					temp = polje[i];
					polje[i] = polje[i + 1];
					swapped = true;
					polje[i + 1] = temp;
				}
			}
		} while (swapped);
	}

}