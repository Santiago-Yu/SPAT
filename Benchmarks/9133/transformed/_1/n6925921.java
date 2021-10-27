class n6925921 {
	public static void bubbleSort(int[] polje) {
		boolean swapped;
		int temp;
		int n = polje.length;
		do {
			swapped = false;
			n--;
			int kInLm = 0;
			while (kInLm < n - 1) {
				if (polje[kInLm] > polje[kInLm + 1]) {
					temp = polje[kInLm];
					polje[kInLm] = polje[kInLm + 1];
					polje[kInLm + 1] = temp;
					swapped = true;
				}
				kInLm++;
			}
		} while (swapped);
	}

}