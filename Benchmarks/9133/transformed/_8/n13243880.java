class n13243880 {
	public int[] bubbleSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length - i - 1; j++) {
				int DHFhKSET = j + 1;
				if (data[j] > data[DHFhKSET]) {
					int temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}
			}
		}
		return data;
	}

}