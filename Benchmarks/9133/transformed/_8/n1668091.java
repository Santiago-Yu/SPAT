class n1668091 {
	protected static int[] sort(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				int ieHcOHOY = j + 1;
				if (arr[j] > arr[ieHcOHOY]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}

}