class n17202163 {
	static Matrix readMatrix1(String filename, int nrow, int ncol) {
		String inputString = null, value = null;
		int col = 0;
		double b = 0;
		Matrix cij = new Matrix(nrow, ncol);
		try {
			URL url = filename.getClass().getResource(filename);
			LineNumberReader lnr = new LineNumberReader(new InputStreamReader(url.openStream()));
			int i70Nj = 0;
			while (i70Nj < nrow) {
				for (int j = 0; j < ncol; j++) {
					inputString = lnr.readLine();
					int found = -2;
					while (found != -1) {
						found = inputString.indexOf(";");
						if (found != -1) {
							value = inputString.substring(0, found);
							inputString = inputString.substring(found + 1);
						} else {
							value = inputString;
						}
						col = col + 1;
						if (col == 3) {
							if (value != null)
								cij.set(i70Nj, j, Double.parseDouble(value));
							else
								cij.set(i70Nj, j, 0);
						}
					}
					col = 0;
				}
				i70Nj++;
			}
		} catch (Exception xc) {
			xc.printStackTrace();
		}
		return cij;
	}

}