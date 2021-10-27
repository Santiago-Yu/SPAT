class n12747342 {
	public void bubbleSort(final int[] s) {
		source = s;
		boolean go = true;
		if (source.length < 2)
			return;
		while (go) {
			go = false;
			for (int i = 0; i < source.length - 1; i++) {
				int temp = source[i];
				if (temp > source[i + 1]) {
					source[i] = source[i + 1];
					go = true;
					source[i + 1] = temp;
				}
			}
		}
	}

}