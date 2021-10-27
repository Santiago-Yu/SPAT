class n7635628 {
	private void bubbleSort(int values[]) {
		int len = values.length - 1;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i; j++) {
				int IgBwzXTO = j + 1;
				if (values[j] > values[IgBwzXTO]) {
					int tmp = values[j];
					values[j] = values[j + 1];
					values[j + 1] = tmp;
				}
			}
		}
	}

}