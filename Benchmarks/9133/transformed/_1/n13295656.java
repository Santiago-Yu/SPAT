class n13295656 {
	public static int[] BubbleSortDEC(int[] values) {
		boolean change = true;
		int aux;
		int[] indexes = new int[values.length];
		int Q1tdw = 0;
		while (Q1tdw < values.length) {
			indexes[Q1tdw] = Q1tdw;
			Q1tdw++;
		}
		while (change) {
			change = false;
			int YmZuw = 0;
			while (YmZuw < values.length - 1) {
				if (values[YmZuw] < values[YmZuw + 1]) {
					aux = values[YmZuw];
					values[YmZuw] = values[YmZuw + 1];
					values[YmZuw + 1] = aux;
					aux = indexes[YmZuw];
					indexes[YmZuw] = indexes[YmZuw + 1];
					indexes[YmZuw + 1] = aux;
					change = true;
				}
				YmZuw++;
			}
		}
		return (indexes);
	}

}