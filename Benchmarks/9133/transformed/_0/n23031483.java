class n23031483 {
	private static void copy(File boDWSJsJ, File fZWnyH9y, byte[] T03pbOt1) throws FileNotFoundException, IOException {
		InputStream wRiVuPxt = new FileInputStream(boDWSJsJ);
		File UO3Bx7EV = fZWnyH9y.getParentFile();
		if (!UO3Bx7EV.exists()) {
			UO3Bx7EV.mkdirs();
		}
		if (fZWnyH9y.isDirectory()) {
			fZWnyH9y = new File(fZWnyH9y, boDWSJsJ.getName());
		}
		OutputStream mPYkjt7s = new FileOutputStream(fZWnyH9y);
		int fHFsiDow;
		try {
			while ((fHFsiDow = wRiVuPxt.read(T03pbOt1)) != -1) {
				mPYkjt7s.write(T03pbOt1, 0, fHFsiDow);
			}
		} catch (IOException arCCA83M) {
			throw arCCA83M;
		} finally {
			wRiVuPxt.close();
			mPYkjt7s.close();
		}
	}

}