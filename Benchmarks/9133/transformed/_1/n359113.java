class n359113 {
	public static void bubbleSort(String[] a) {
		Collator myCollator = Collator.getInstance();
		boolean switched = true;
		int zNbir = 0;
		while (zNbir < a.length - 1 && switched) {
			switched = false;
			for (int i = 0; i < a.length - zNbir - 1; i++) {
				if (myCollator.compare(a[i], a[i + 1]) > 0) {
					switched = true;
					String temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}
			zNbir++;
		}
	}

}