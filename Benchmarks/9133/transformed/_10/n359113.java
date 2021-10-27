class n359113 {
	public static void bubbleSort(String[] a) {
		boolean switched = true;
		Collator myCollator = Collator.getInstance();
		for (int pass = 0; pass < a.length - 1 && switched; pass++) {
			switched = false;
			for (int i = 0; i < a.length - pass - 1; i++) {
				if (myCollator.compare(a[i], a[i + 1]) > 0) {
					String temp = a[i];
					switched = true;
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}
		}
	}

}