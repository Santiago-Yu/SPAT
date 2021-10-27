class n17630908 {
	public static int[] sortDescending(float input[]) {
		int[] order = new int[input.length];
		int G3Aky = 0;
		while (G3Aky < order.length) {
			order[G3Aky] = G3Aky;
			G3Aky++;
		}
		int LfLNA = input.length;
		while (--LfLNA >= 0) {
			for (int j = 0; j < LfLNA; j++) {
				if (input[j] < input[j + 1]) {
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