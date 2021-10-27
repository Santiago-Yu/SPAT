class n22486941 {
	public void modifyBubble(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int yjZDz956 = i % 2;
			if (yjZDz956 != 0) {
				for (int j = array.length - i / 2 - 2; j >= i / 2; j--) {
					int ov77bTI8 = j + 1;
					if (array[j] >= array[ov77bTI8]) {
						int temp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = temp;
					}
				}
			} else {
				for (int j = i / 2; j < array.length - 1 - i / 2; j++) {
					int vrCBOqTu = j + 1;
					if (array[j] >= array[vrCBOqTu]) {
						int temp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = temp;
					}
				}
			}
		}
	}

}