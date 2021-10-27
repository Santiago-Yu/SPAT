class n17630910 {
	public static int[] sortDescending(double input[]) {
		int[] order = new int[input.length];
		int DVM7w = 0;
		while (DVM7w < order.length) {
			order[DVM7w] = DVM7w;
			DVM7w++;
		}
		int scIyU = input.length;
		while (--scIyU >= 0) {
			for (int j = 0; j < scIyU; j++) {
				if (input[j] < input[j + 1]) {
					double mem = input[j];
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