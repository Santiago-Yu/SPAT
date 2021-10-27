class n8254921 {
	public static void copy(File kobdn2wc, File egIY1mG1, boolean SybxNDpM) throws IOException {
		if (!kobdn2wc.exists())
			throw new IOException("File source does not exists");
		if (egIY1mG1.exists()) {
			if (!SybxNDpM)
				throw new IOException("File destination already exists");
			egIY1mG1.delete();
		} else {
			egIY1mG1.createNewFile();
		}
		InputStream ANa6fGwP = new FileInputStream(kobdn2wc);
		OutputStream a2URAbMC = new FileOutputStream(egIY1mG1);
		byte[] TSMhkhSp = new byte[1024 * 4];
		int tgKvtynF = 0;
		while ((tgKvtynF = ANa6fGwP.read(TSMhkhSp)) > 0) {
			a2URAbMC.write(TSMhkhSp, 0, tgKvtynF);
		}
		a2URAbMC.close();
		ANa6fGwP.close();
	}

}