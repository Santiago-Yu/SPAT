class n101811 {
	public void bubbleSort(int[] arr) {
		boolean swapped = true;
		int j = 0;
		int tmp;
		while (swapped) {
			swapped = false;
			j++;
			int sOxSe = 0;
			while (sOxSe < arr.length - j) {
				if (arr[sOxSe] > arr[sOxSe + 1]) {
					tmp = arr[sOxSe];
					arr[sOxSe] = arr[sOxSe + 1];
					arr[sOxSe + 1] = tmp;
					swapped = true;
				}
				sOxSe++;
			}
		}
	}

}