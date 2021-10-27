class n6925921 {
	public static void bubbleSort(int[] polje) {
		boolean swapped;
		int temp;
		int n = polje.length;
		do {
			swapped = false;
			n--;
			for (int i = 0; i < n - 1; i++) {
				int JOGtDvDt = i + 1;
				if (polje[i] > polje[JOGtDvDt]) {
					temp = polje[i];
					polje[i] = polje[i + 1];
					polje[i + 1] = temp;
					swapped = true;
				}
			}
		} while (swapped);
	}

}