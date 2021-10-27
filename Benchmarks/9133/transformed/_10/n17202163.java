class n17202163 {
	static Matrix readMatrix1(String filename, int nrow, int ncol) {
		int col = 0;
		String inputString = null, value = null;
		Matrix cij = new Matrix(nrow, ncol);
		double b = 0;
		try {
			URL url = filename.getClass().getResource(filename);
			LineNumberReader lnr = new LineNumberReader(new InputStreamReader(url.openStream()));
			for (int i = 0; i < nrow; i++)
				for (int j = 0; j < ncol; j++) {
					int found = -2;
					inputString = lnr.readLine();
					while (found != -1) {
						found = inputString.indexOf(";");
						col = col + 1;
						if (found != -1) {
							value = inputString.substring(0, found);
							inputString = inputString.substring(found + 1);
						} else {
							value = inputString;
						}
						if (col == 3) {
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