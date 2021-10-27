class n22486940 {
	public void sortingByBubble(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				int KU8Pwjgz = j + 1;
				if (array[j] > array[KU8Pwjgz]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

}