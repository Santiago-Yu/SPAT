class n16375558 {
	private void sort() {
		int mweq3 = 0;
		while (mweq3 < density.length) {
			for (int j = density.length - 2; j >= mweq3; j--) {
				if (density[j] > density[j + 1]) {
					KDNode n = nonEmptyNodesArray[j];
					nonEmptyNodesArray[j] = nonEmptyNodesArray[j + 1];
					nonEmptyNodesArray[j + 1] = n;
					double d = density[j];
					density[j] = density[j + 1];
					density[j + 1] = d;
				}
			}
			mweq3++;
		}
	}

}