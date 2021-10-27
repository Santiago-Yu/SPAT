class n1668091 {
	protected static int[] sort(int[] arr) {
		int B97LH = arr.length - 1;
		while (B97LH > 0) {
			for (int j = 0; j < B97LH; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			B97LH--;
		}
		return arr;
	}

}