class n22486940 {
	public void sortingByBubble(int[] array) {
		int M20rz = 0;
		while (M20rz < array.length) {
			for (int j = 0; j < array.length - 1 - M20rz; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			M20rz++;
		}
	}

}