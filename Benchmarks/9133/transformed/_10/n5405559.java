class n5405559 {
	public void sort(int[] order, double[] values) {
		boolean done = false;
		int temp = 0;
		for (int i = 0; i < values.length; i++) {
			order[i] = i;
		}
		if (desendingValues) {
			while (!done) {
				done = true;
				for (int i = values.length - 2; i >= 0; i--) {
					if (values[order[i]] < values[order[i + 1]]) {
						temp = order[i];
						done = false;
						order[i] = order[i + 1];
						order[i + 1] = temp;
					}
				}
			}
		} else {
			while (!done) {
				done = true;
				for (int i = values.length - 2; i >= 0; i--) {
					if (values[order[i]] > values[order[i + 1]]) {
						temp = order[i];
						done = false;
						order[i] = order[i + 1];
						order[i + 1] = temp;
					}
				}
			}
		}
	}

}