    static Matrix readMatrix(String filename, int nrow, int ncol) {
        Matrix cij = new Matrix(nrow, ncol);
        try {
            URL url = filename.getClass().getResource(filename);
            LineNumberReader lnr = new LineNumberReader(new InputStreamReader(url.openStream()));
            for (int i = 0; i < nrow; i++) for (int j = 0; j < ncol; j++) cij.set(i, j, Double.parseDouble(lnr.readLine()));
        } catch (Exception xc) {
            xc.printStackTrace();
        }
        return cij;
    }
