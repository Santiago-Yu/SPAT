class n763710 {
	public void bubbleSort(int[] I8JLnu4Z) {
		boolean HExl2qQP = true;
		int BOf2YxKi = 0;
		int hkqFRq1Q;
		while (HExl2qQP) {
			HExl2qQP = false;
			BOf2YxKi++;
			for (int Os0UaNf2 = 0; Os0UaNf2 < I8JLnu4Z.length - BOf2YxKi; Os0UaNf2++) {
				if (I8JLnu4Z[Os0UaNf2] > I8JLnu4Z[Os0UaNf2 + 1]) {
					hkqFRq1Q = I8JLnu4Z[Os0UaNf2];
					I8JLnu4Z[Os0UaNf2] = I8JLnu4Z[Os0UaNf2 + 1];
					I8JLnu4Z[Os0UaNf2 + 1] = hkqFRq1Q;
					HExl2qQP = true;
				}
			}
		}
	}

}