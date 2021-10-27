class n115129 {
	public static void bubbleSort(String[] a) {
		Collator myCollator = Collator.getInstance();
		boolean switched = true;
		int nFJMS = 0;
		while (nFJMS < a.length - 1 && switched) {
			switched = false;
			for (int i = 0; i < a.length - nFJMS - 1; i++) {
				if (myCollator.compare(a[i], a[i + 1]) > 0) {
					switched = true;
					String temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}
			nFJMS++;
		}
	}

}