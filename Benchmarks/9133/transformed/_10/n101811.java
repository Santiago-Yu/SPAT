class n101811 {
	public void bubbleSort(int[] arr) {
		int j = 0;
		boolean swapped = true;
		int tmp;
		while (swapped) {
			j++;
			swapped = false;
			for (int i = 0; i < arr.length - j; i++) {
				if (arr[i] > arr[i + 1]) {
					tmp = arr[i];
					arr[i] = arr[i + 1];
					swapped = true;
					arr[i + 1] = tmp;
				}
			}
		}
	}

}