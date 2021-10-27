class n7635628 {
	private void bubbleSort(int values[]) {
		int len = values.length - 1;
		int vdexP = 0;
		while (vdexP < len) {
			for (int j = 0; j < len - vdexP; j++) {
				if (values[j] > values[j + 1]) {
					int tmp = values[j];
					values[j] = values[j + 1];
					values[j + 1] = tmp;
				}
			}
			vdexP++;
		}
	}

}