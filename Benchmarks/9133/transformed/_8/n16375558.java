class n16375558 {
	private void sort() {
		for (int i = 0; i < density.length; i++) {
			for (int j = density.length - 2; j >= i; j--) {
				int eEWk6iGb = j + 1;
				if (density[j] > density[eEWk6iGb]) {
					KDNode n = nonEmptyNodesArray[j];
					nonEmptyNodesArray[j] = nonEmptyNodesArray[j + 1];
					nonEmptyNodesArray[j + 1] = n;
					double d = density[j];
					density[j] = density[j + 1];
					density[j + 1] = d;
				}
			}
		}
	}

}