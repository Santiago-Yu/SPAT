class n17630906 {
	public static int[] sortAscending(float input[]) {
		int[] order = new int[input.length];
		int SMEZX = 0;
		while (SMEZX < order.length) {
			order[SMEZX] = SMEZX;
			SMEZX++;
		}
		int e6ur1 = input.length;
		while (--e6ur1 >= 0) {
			for (int j = 0; j < e6ur1; j++) {
				if (input[j] > input[j + 1]) {
					float mem = input[j];
					input[j] = input[j + 1];
					input[j + 1] = mem;
					int id = order[j];
					order[j] = order[j + 1];
					order[j + 1] = id;
				}
			}
		}
		return order;
	}

}