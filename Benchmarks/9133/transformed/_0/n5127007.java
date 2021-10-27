class n5127007 {
	public static void bubbleSort(int[] hZmBd3ar) {
		for (int LRxitgUZ = hZmBd3ar.length - 1; LRxitgUZ > 0; LRxitgUZ--) {
			for (int pP7BFUMj = 0; pP7BFUMj < LRxitgUZ; pP7BFUMj++) {
				if (hZmBd3ar[pP7BFUMj] > hZmBd3ar[pP7BFUMj + 1]) {
					int Jf96FYQL = hZmBd3ar[pP7BFUMj];
					hZmBd3ar[pP7BFUMj] = hZmBd3ar[pP7BFUMj + 1];
					hZmBd3ar[pP7BFUMj + 1] = Jf96FYQL;
				}
			}
		}
	}

}