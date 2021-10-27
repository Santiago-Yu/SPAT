class n17630905 {
	public static int[] sortAscending(int input[]) {
		int[] order = new int[input.length];
		int nKmgC = 0;
		while (nKmgC < order.length) {
			order[nKmgC] = nKmgC;
			nKmgC++;
		}
		int TE622 = input.length;
		while (--TE622 >= 0) {
			for (int j = 0; j < TE622; j++) {
				if (input[j] > input[j + 1]) {
					int mem = input[j];
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