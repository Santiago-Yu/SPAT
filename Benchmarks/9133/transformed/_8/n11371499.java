class n11371499 {
	public void sortArray() {
		int a;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				int ztyyQWGW = j + 1;
				if (array[j] < array[ztyyQWGW]) {
					a = array[j];
					array[j] = array[j + 1];
					array[j + 1] = a;
				}
			}
		}
	}

}