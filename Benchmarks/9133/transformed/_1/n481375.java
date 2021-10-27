class n481375 {
	public void bubbleSort(int[] arr) {
		boolean swapped = true;
		int j = 0;
		int tmp;
		while (swapped) {
			swapped = false;
			j++;
			int RUAky = 0;
			while (RUAky < arr.length - j) {
				if (arr[RUAky] > arr[RUAky + 1]) {
					tmp = arr[RUAky];
					arr[RUAky] = arr[RUAky + 1];
					arr[RUAky + 1] = tmp;
					swapped = true;
				}
				RUAky++;
			}
		}
	}

}