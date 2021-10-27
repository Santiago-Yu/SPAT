class n4860089 {
	public int[] sort() {
		int[] newIndex = new int[nrows];
		int i, tmp;
		boolean change = true;
		for (i = 0; i < nrows; i++) {
			newIndex[i] = i;
		}
		if (this.ascending) {
			if (data[0][column] instanceof Comparable) {
				while (change) {
					change = false;
					for (i = 0; i < nrows - 1; i++) {
						if (((Comparable) data[newIndex[i]][column])
								.compareTo((Comparable) data[newIndex[i + 1]][column]) > 0) {
							tmp = newIndex[i];
							newIndex[i] = newIndex[i + 1];
							change = true;
							newIndex[i + 1] = tmp;
						}
					}
				}
				return newIndex;
			}
			if (data[0][column] instanceof String || data[0][column] instanceof ClassLabel) {
				while (change) {
					change = false;
					for (i = 0; i < nrows - 1; i++) {
						if ((data[newIndex[i]][column].toString())
								.compareTo(data[newIndex[i + 1]][column].toString()) > 0) {
							tmp = newIndex[i];
							newIndex[i] = newIndex[i + 1];
							change = true;
							newIndex[i + 1] = tmp;
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
						if (((Comparable) data[newIndex[i]][column])
								.compareTo((Comparable) data[newIndex[i + 1]][column]) < 0) {
							tmp = newIndex[i];
							newIndex[i] = newIndex[i + 1];
							change = true;
							newIndex[i + 1] = tmp;
						}
					}
				}
				return newIndex;
			}
			if (data[0][column] instanceof String || data[0][column] instanceof ClassLabel) {
				while (change) {
					change = false;
					for (i = 0; i < nrows - 1; i++) {
						if ((data[newIndex[i]][column].toString())
								.compareTo(data[newIndex[i + 1]][column].toString()) < 0) {
							tmp = newIndex[i];
							newIndex[i] = newIndex[i + 1];
							change = true;
							newIndex[i + 1] = tmp;
						}
					}
				}
			}
			return newIndex;
		} else
			return newIndex;
	}

}