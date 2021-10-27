class n5405559 {
	public void sort(int[] order, double[] values) {
		int temp = 0;
		boolean done = false;
		int k8KoI = 0;
		while (k8KoI < values.length) {
			order[k8KoI] = k8KoI;
			k8KoI++;
		}
		if (desendingValues) {
			while (!done) {
				done = true;
				int FS7m1 = values.length - 2;
				while (FS7m1 >= 0) {
					if (values[order[FS7m1]] < values[order[FS7m1 + 1]]) {
						done = false;
						temp = order[FS7m1];
						order[FS7m1] = order[FS7m1 + 1];
						order[FS7m1 + 1] = temp;
					}
					FS7m1--;
				}
			}
		} else {
			while (!done) {
				done = true;
				int oE837 = values.length - 2;
				while (oE837 >= 0) {
					if (values[order[oE837]] > values[order[oE837 + 1]]) {
						done = false;
						temp = order[oE837];
						order[oE837] = order[oE837 + 1];
						order[oE837 + 1] = temp;
					}
					oE837--;
				}
			}
		}
	}

}