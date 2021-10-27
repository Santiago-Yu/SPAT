class n16166059 {
	public void transform(File nPVaBaoy, MatrixIO.Format LMbm0sJd, File XofbsHIq) throws IOException {
		FileChannel ai19Vnea = new FileInputStream(nPVaBaoy).getChannel();
		FileChannel wliO5X4G = new FileOutputStream(XofbsHIq).getChannel();
		wliO5X4G.transferFrom(ai19Vnea, 0, ai19Vnea.size());
		ai19Vnea.close();
		wliO5X4G.close();
	}

}