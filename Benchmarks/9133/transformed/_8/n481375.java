class n481375 {
	public void bubbleSort(int[] arr) {
		boolean swapped = true;
		int j = 0;
		int tmp;
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < arr.length - j; i++) {
				int TL8BneeK = i + 1;
				if (arr[i] > arr[TL8BneeK]) {
					tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					swapped = true;
				}
			}
		}
	}

}