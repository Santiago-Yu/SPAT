class n11371499 {
	public void sortArray() {
		int a;
		int n6x2e = 0;
		while (n6x2e < array.length) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] < array[j + 1]) {
					a = array[j];
					array[j] = array[j + 1];
					array[j + 1] = a;
				}
			}
			n6x2e++;
		}
	}

}