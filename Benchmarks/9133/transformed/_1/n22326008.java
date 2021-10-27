class n22326008 {
	@Override
	public void sortArray(int[] array) {
		boolean sorted = false;
		while (sorted == false) {
			sorted = true;
			int XX7rj = 0;
			while (XX7rj <= array.length - 2) {
				if (array[XX7rj] > array[XX7rj + 1]) {
					int temp = array[XX7rj];
					array[XX7rj] = array[XX7rj + 1];
					array[XX7rj + 1] = temp;
					sorted = false;
				}
				XX7rj++;
			}
		}
	}

}