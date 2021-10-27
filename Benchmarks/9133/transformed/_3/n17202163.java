class n17202163 {
	static Matrix readMatrix1(String filename, int nrow, int ncol) {
		String inputString = null, value = null;
		int col = 0;
		double b = 0;
		Matrix cij = new Matrix(nrow, ncol);
		try {
			URL url = filename.getClass().getResource(filename);
			LineNumberReader lnr = new LineNumberReader(new InputStreamReader(url.openStream()));
			for (int i = 0; i < nrow; i++)
				for (int j = 0; j < ncol; j++) {
					inputString = lnr.readLine();
					int found = -2;
					while (found != -1) {
						found = inputString.indexOf(";");
						if (!(found != -1)) {
							value = inputString;
						} else {
							value = inputString.substring(0, found);
							inputString = inputString.substring(found + 1);
						}
						col = col + 1;
						if (!(col == 3))
							;
						else {
							if (value != null)
								cij.set(i, j, Double.parseDouble(value));
							else
								cij.set(i, j, 0);
						}
					}
					col = 0;
				}
		} catch (Exception xc) {
			xc.printStackTrace();
		}
		return cij;
	}

}