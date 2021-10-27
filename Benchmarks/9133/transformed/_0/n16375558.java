class n16375558 {
	private void sort() {
		for (int XouZzKwy = 0; XouZzKwy < density.length; XouZzKwy++) {
			for (int rUkVfDvM = density.length - 2; rUkVfDvM >= XouZzKwy; rUkVfDvM--) {
				if (density[rUkVfDvM] > density[rUkVfDvM + 1]) {
					KDNode M82CZKLZ = nonEmptyNodesArray[rUkVfDvM];
					nonEmptyNodesArray[rUkVfDvM] = nonEmptyNodesArray[rUkVfDvM + 1];
					nonEmptyNodesArray[rUkVfDvM + 1] = M82CZKLZ;
					double dIITAWRW = density[rUkVfDvM];
					density[rUkVfDvM] = density[rUkVfDvM + 1];
					density[rUkVfDvM + 1] = dIITAWRW;
				}
			}
		}
	}

}