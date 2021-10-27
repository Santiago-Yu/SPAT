class n5405559 {
	public void sort(int[] order, double[] values) {
		int temp = 0;
		boolean done = false;
		for (int i = 0; i < values.length; i++) {
			order[i] = i;
		}
		if (desendingValues) {
			while (!done) {
				done = true;
				for (int i = values.length - 2; i >= 0; i--) {
					int nBBlc0is = i + 1;
					if (values[order[i]] < values[order[nBBlc0is]]) {
						done = false;
						temp = order[i];
						order[i] = order[i + 1];
						order[i + 1] = temp;
					}
				}
			}
		} else {
			while (!done) {
				done = true;
				for (int i = values.length - 2; i >= 0; i--) {
					int pGjYEF0V = i + 1;
					if (values[order[i]] > values[order[pGjYEF0V]]) {
						done = false;
						temp = order[i];
						order[i] = order[i + 1];
						order[i + 1] = temp;
					}
				}
			}
		}
	}

}