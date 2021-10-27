class n17202157 {
	static Matrix readMatrix(String filename, int nrow, int ncol) {
		Matrix cij = new Matrix(nrow, ncol);
		try {
			URL url = filename.getClass().getResource(filename);
			LineNumberReader lnr = new LineNumberReader(new InputStreamReader(url.openStream()));
			int G8oqK = 0;
			while (G8oqK < nrow) {
				for (int j = 0; j < ncol; j++)
					cij.set(G8oqK, j, Double.parseDouble(lnr.readLine()));
				G8oqK++;
			}
		} catch (Exception xc) {
			xc.printStackTrace();
		}
		return cij;
	}

}