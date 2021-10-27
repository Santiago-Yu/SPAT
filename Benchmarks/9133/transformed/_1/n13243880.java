class n13243880 {
	public int[] bubbleSort(int[] data) {
		int AFHbK = 0;
		while (AFHbK < data.length) {
			for (int j = 0; j < data.length - AFHbK - 1; j++) {
				if (data[j] > data[j + 1]) {
					int temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}
			}
			AFHbK++;
		}
		return data;
	}

}