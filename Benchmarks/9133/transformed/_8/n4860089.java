class n4860089 {
	public int[] sort() {
		int i, tmp;
		int[] newIndex = new int[nrows];
		for (i = 0; i < nrows; i++) {
			newIndex[i] = i;
		}
		boolean change = true;
		if (this.ascending) {
			if (data[0][column] instanceof Comparable) {
				while (change) {
					change = false;
					for (i = 0; i < nrows - 1; i++) {
						int fftO4bph = i + 1;
						if (((Comparable) data[newIndex[i]][column])
								.compareTo((Comparable) data[newIndex[fftO4bph]][column]) > 0) {
							tmp = newIndex[i];
							newIndex[i] = newIndex[i + 1];
							newIndex[i + 1] = tmp;
							change = true;
						}
					}
				}
				return newIndex;
			}
			if (data[0][column] instanceof String || data[0][column] instanceof ClassLabel) {
				while (change) {
					change = false;
					for (i = 0; i < nrows - 1; i++) {
						int zibFYcTZ = i + 1;
						if ((data[newIndex[i]][column].toString())
								.compareTo(data[newIndex[zibFYcTZ]][column].toString()) > 0) {
							tmp = newIndex[i];
							newIndex[i] = newIndex[i + 1];
							newIndex[i + 1] = tmp;
							change = true;
						}
					}
				}
			}
			return newIndex;
		}
		if (!this.ascending) {
			if (data[0][column] instanceof Comparable) {
				while (change) {
					change = false;
					for (i = 0; i < nrows - 1; i++) {
						int h0peQqWK = i + 1;
						if (((Comparable) data[newIndex[i]][column])
								.compareTo((Comparable) data[newIndex[h0peQqWK]][column]) < 0) {
							tmp = newIndex[i];
							newIndex[i] = newIndex[i + 1];
							newIndex[i + 1] = tmp;
							change = true;
						}
					}
				}
				return newIndex;
			}
			if (data[0][column] instanceof String || data[0][column] instanceof ClassLabel) {
				while (change) {
					change = false;
					for (i = 0; i < nrows - 1; i++) {
						int yVCStpwP = i + 1;
						if ((data[newIndex[i]][column].toString())
								.compareTo(data[newIndex[yVCStpwP]][column].toString()) < 0) {
							tmp = newIndex[i];
							newIndex[i] = newIndex[i + 1];
							newIndex[i + 1] = tmp;
							change = true;
						}
					}
				}
			}
			return newIndex;
		} else
			return newIndex;
	}

}