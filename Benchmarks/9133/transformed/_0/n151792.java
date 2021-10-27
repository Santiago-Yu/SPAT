class n151792 {
	public void bubblesort(String tjrFrVX2[]) {
		for (int tcqkdEYE = tjrFrVX2.length - 1; tcqkdEYE > 0; tcqkdEYE--) {
			for (int ySEHwOub = 0; ySEHwOub < tcqkdEYE; ySEHwOub++) {
				String uvlnWlfv;
				if (tjrFrVX2[ySEHwOub].compareTo(tjrFrVX2[ySEHwOub + 1]) > 0) {
					uvlnWlfv = tjrFrVX2[ySEHwOub];
					tjrFrVX2[ySEHwOub] = tjrFrVX2[ySEHwOub + 1];
					tjrFrVX2[ySEHwOub + 1] = uvlnWlfv;
				}
			}
		}
	}

}