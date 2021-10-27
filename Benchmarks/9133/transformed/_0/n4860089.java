class n4860089 {
	public int[] sort() {
		int odKl81GS, HvJnbFUu;
		int[] w59ABiex = new int[nrows];
		for (odKl81GS = 0; odKl81GS < nrows; odKl81GS++) {
			w59ABiex[odKl81GS] = odKl81GS;
		}
		boolean LwRFkeHX = true;
		if (this.ascending) {
			if (data[0][column] instanceof Comparable) {
				while (LwRFkeHX) {
					LwRFkeHX = false;
					for (odKl81GS = 0; odKl81GS < nrows - 1; odKl81GS++) {
						if (((Comparable) data[w59ABiex[odKl81GS]][column])
								.compareTo((Comparable) data[w59ABiex[odKl81GS + 1]][column]) > 0) {
							HvJnbFUu = w59ABiex[odKl81GS];
							w59ABiex[odKl81GS] = w59ABiex[odKl81GS + 1];
							w59ABiex[odKl81GS + 1] = HvJnbFUu;
							LwRFkeHX = true;
						}
					}
				}
				return w59ABiex;
			}
			if (data[0][column] instanceof String || data[0][column] instanceof ClassLabel) {
				while (LwRFkeHX) {
					LwRFkeHX = false;
					for (odKl81GS = 0; odKl81GS < nrows - 1; odKl81GS++) {
						if ((data[w59ABiex[odKl81GS]][column].toString())
								.compareTo(data[w59ABiex[odKl81GS + 1]][column].toString()) > 0) {
							HvJnbFUu = w59ABiex[odKl81GS];
							w59ABiex[odKl81GS] = w59ABiex[odKl81GS + 1];
							w59ABiex[odKl81GS + 1] = HvJnbFUu;
							LwRFkeHX = true;
						}
					}
				}
			}
			return w59ABiex;
		}
		if (!this.ascending) {
			if (data[0][column] instanceof Comparable) {
				while (LwRFkeHX) {
					LwRFkeHX = false;
					for (odKl81GS = 0; odKl81GS < nrows - 1; odKl81GS++) {
						if (((Comparable) data[w59ABiex[odKl81GS]][column])
								.compareTo((Comparable) data[w59ABiex[odKl81GS + 1]][column]) < 0) {
							HvJnbFUu = w59ABiex[odKl81GS];
							w59ABiex[odKl81GS] = w59ABiex[odKl81GS + 1];
							w59ABiex[odKl81GS + 1] = HvJnbFUu;
							LwRFkeHX = true;
						}
					}
				}
				return w59ABiex;
			}
			if (data[0][column] instanceof String || data[0][column] instanceof ClassLabel) {
				while (LwRFkeHX) {
					LwRFkeHX = false;
					for (odKl81GS = 0; odKl81GS < nrows - 1; odKl81GS++) {
						if ((data[w59ABiex[odKl81GS]][column].toString())
								.compareTo(data[w59ABiex[odKl81GS + 1]][column].toString()) < 0) {
							HvJnbFUu = w59ABiex[odKl81GS];
							w59ABiex[odKl81GS] = w59ABiex[odKl81GS + 1];
							w59ABiex[odKl81GS + 1] = HvJnbFUu;
							LwRFkeHX = true;
						}
					}
				}
			}
			return w59ABiex;
		} else
			return w59ABiex;
	}

}