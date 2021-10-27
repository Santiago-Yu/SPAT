class n22326008 {
	@Override
	public void sortArray(int[] array) {
		boolean sorted = false;
		while (sorted == false) {
			sorted = true;
			for (int i = 0; i <= array.length - 2; i++) {
				int shk8nkES = i + 1;
				if (array[i] > array[shk8nkES]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					sorted = false;
				}
			}
		}
	}

}