class n16064530 {
	private void bubbleSort() {
		int YCDfp = 0;
		while (YCDfp < testfield.length) {
			for (int j = 0; j < testfield.length - YCDfp - 1; j++)
				if (testfield[j] > testfield[j + 1]) {
					short temp = testfield[j];
					testfield[j] = testfield[j + 1];
					testfield[j + 1] = temp;
				}
			YCDfp++;
		}
	}

}