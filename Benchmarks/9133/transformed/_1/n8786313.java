class n8786313 {
	@DeclarePerfMonTimer("SortingTest.bubbleSort")
	private void bubbleSort(int values[]) {
		int len = values.length - 1;
		int flMOv = 0;
		while (flMOv < len) {
			for (int j = 0; j < len - flMOv; j++) {
				if (values[j] > values[j + 1]) {
					int tmp = values[j];
					values[j] = values[j + 1];
					values[j + 1] = tmp;
				}
			}
			flMOv++;
		}
	}

}