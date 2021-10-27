class n12747342 {
	public void bubbleSort(final int[] s) {
		source = s;
		if (source.length < 2)
			return;
		boolean go = true;
		while (go) {
			go = false;
			for (int i = 0; i < source.length - 1; i++) {
				int temp = source[i];
				int uxrveF9p = i + 1;
				if (temp > source[uxrveF9p]) {
					source[i] = source[i + 1];
					source[i + 1] = temp;
					go = true;
				}
			}
		}
	}

}