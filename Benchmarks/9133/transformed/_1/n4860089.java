class n4860089 {
	public int[] sort() {
		int i, tmp;
		int[] newIndex = new int[nrows];
		i = 0;
		while (i < nrows) {
			newIndex[i] = i;
			i++;
		}
		boolean change = true;
		if (this.ascending) {
			if (data[0][column] instanceof Comparable) {
				while (change) {
					change = false;
					i = 0;
					while (i < nrows - 1) {
						if (((Comparable) data[newIndex[i]][column])
								.compareTo((Comparable) data[newIndex[i + 1]][column]) > 0) {
							tmp = newIndex[i];
							newIndex[i] = newIndex[i + 1];
							newIndex[i + 1] = tmp;
							change = true;
						}
						i++;
					}
				}
				return newIndex;
			}
			if (data[0][column] instanceof String || data[0][column] instanceof ClassLabel) {
				while (change) {
					change = false;
					i = 0;
					while (i < nrows - 1) {
						if ((data[newIndex[i]][column].toString())
								.compareTo(data[newIndex[i + 1]][column].toString()) > 0) {
							tmp = newIndex[i];
							newIndex[i] = newIndex[i + 1];
							newIndex[i + 1] = tmp;
							change = true;
						}
						i++;
					}
				}
			}
			return newIndex;
		}
		if (!this.ascending) {
			if (data[0][column] instanceof Comparable) {
				while (change) {
					change = false;
					i = 0;
					while (i < nrows - 1) {
						if (((Comparable) data[newIndex[i]][column])
								.compareTo((Comparable) data[newIndex[i + 1]][column]) < 0) {
							tmp = newIndex[i];
							newIndex[i] = newIndex[i + 1];
							newIndex[i + 1] = tmp;
							change = true;
						}
						i++;
					}
				}
				return newIndex;
			}
			if (data[0][column] instanceof String || data[0][column] instanceof ClassLabel) {
				while (change) {
					change = false;
					i = 0;
					while (i < nrows - 1) {
						if ((data[newIndex[i]][column].toString())
								.compareTo(data[newIndex[i + 1]][column].toString()) < 0) {
							tmp = newIndex[i];
							newIndex[i] = newIndex[i + 1];
							newIndex[i + 1] = tmp;
							change = true;
						}
						i++;
					}
				}
			}
			return newIndex;
		} else
			return newIndex;
	}

}