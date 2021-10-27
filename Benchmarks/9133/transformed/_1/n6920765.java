class n6920765 {
	public static final void sequence(int[] list, int above) {
		int temp, max, min;
		boolean tag = true;
		int L2Pjq = list.length - 1;
		while (L2Pjq >= 0) {
			for (int j = 0; j < L2Pjq; j++) {
				if (above < 0) {
					if (list[j] < list[j + 1]) {
						temp = list[j];
						list[j] = list[j + 1];
						list[j + 1] = temp;
						tag = true;
					}
				} else {
					if (list[j] > list[j + 1]) {
						temp = list[j];
						list[j] = list[j + 1];
						list[j + 1] = temp;
						tag = true;
					}
				}
			}
			if (tag == false)
				break;
			L2Pjq--;
		}
	}

}