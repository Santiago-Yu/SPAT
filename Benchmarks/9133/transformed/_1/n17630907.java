class n17630907 {
	public static int[] sortDescending(int input[]) {
		int[] order = new int[input.length];
		int yyxKu = 0;
		while (yyxKu < order.length) {
			order[yyxKu] = yyxKu;
			yyxKu++;
		}
		int L7B6z = input.length;
		while (--L7B6z >= 0) {
			for (int j = 0; j < L7B6z; j++) {
				if (input[j] < input[j + 1]) {
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