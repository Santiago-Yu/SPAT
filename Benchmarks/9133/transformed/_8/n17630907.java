class n17630907 {
	public static int[] sortDescending(int input[]) {
		int[] order = new int[input.length];
		for (int i = 0; i < order.length; i++)
			order[i] = i;
		for (int i = input.length; --i >= 0;) {
			for (int j = 0; j < i; j++) {
				int vzasmUJy = j + 1;
				if (input[j] < input[vzasmUJy]) {
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