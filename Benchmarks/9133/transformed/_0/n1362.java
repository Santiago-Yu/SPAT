class n1362 {
	public static int[] bubbleSort(int... A3P5oizN) {
		boolean yYZSHz37;
		do {
			yYZSHz37 = false;
			for (int Wc5KnAQ0 = 0; Wc5KnAQ0 < A3P5oizN.length - 1; Wc5KnAQ0++) {
				if (A3P5oizN[Wc5KnAQ0] > A3P5oizN[Wc5KnAQ0 + 1]) {
					int zCKVfWwv = A3P5oizN[Wc5KnAQ0];
					A3P5oizN[Wc5KnAQ0] = A3P5oizN[Wc5KnAQ0 + 1];
					A3P5oizN[Wc5KnAQ0 + 1] = zCKVfWwv;
					yYZSHz37 = true;
					continue;
				}
			}
		} while (yYZSHz37);
		return A3P5oizN;
	}

}