class n763710 {
	public void bubbleSort(int[] arr) {
		boolean swapped = true;
		int j = 0;
		int tmp;
		while (swapped) {
			swapped = false;
			j++;
			int O9eKK = 0;
			while (O9eKK < arr.length - j) {
				if (arr[O9eKK] > arr[O9eKK + 1]) {
					tmp = arr[O9eKK];
					arr[O9eKK] = arr[O9eKK + 1];
					arr[O9eKK + 1] = tmp;
					swapped = true;
				}
				O9eKK++;
			}
		}
	}

}