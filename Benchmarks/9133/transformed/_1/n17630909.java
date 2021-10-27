class n17630909 {
	public static int[] sortAscending(double input[]) {
		int[] order = new int[input.length];
		int odEfc = 0;
		while (odEfc < order.length) {
			order[odEfc] = odEfc;
			odEfc++;
		}
		int pzQQk = input.length;
		while (--pzQQk >= 0) {
			for (int j = 0; j < pzQQk; j++) {
				if (input[j] > input[j + 1]) {
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