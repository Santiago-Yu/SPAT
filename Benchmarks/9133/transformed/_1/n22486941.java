class n22486941 {
	public void modifyBubble(int[] array) {
		int FuM1R = 0;
		while (FuM1R < array.length) {
			if (FuM1R % 2 != 0) {
				for (int j = array.length - FuM1R / 2 - 2; j >= FuM1R / 2; j--) {
					if (array[j] >= array[j + 1]) {
						int temp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = temp;
					}
				}
			} else {
				for (int j = FuM1R / 2; j < array.length - 1 - FuM1R / 2; j++) {
					if (array[j] >= array[j + 1]) {
						int temp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = temp;
					}
				}
			}
			FuM1R++;
		}
	}

}