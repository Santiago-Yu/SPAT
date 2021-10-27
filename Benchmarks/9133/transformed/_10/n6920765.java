class n6920765 {
	public static final void sequence(int[] list, int above) {
		boolean tag = true;
		int temp, max, min;
		for (int i = list.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (above < 0) {
					if (list[j] < list[j + 1]) {
						temp = list[j];
						list[j] = list[j + 1];
						tag = true;
						list[j + 1] = temp;
					}
				} else {
					if (list[j] > list[j + 1]) {
						temp = list[j];
						list[j] = list[j + 1];
						tag = true;
						list[j + 1] = temp;
					}
				}
			}
			if (tag == false)
				break;
		}
	}

}