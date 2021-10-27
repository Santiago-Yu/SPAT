class n10089329 {
	public static void copy(File NMzD2GKc, File UIuniCdw) throws IOException {
		if (!NMzD2GKc.exists())
			return;
		OutputStream U2nrVzq4 = new FileOutputStream(UIuniCdw);
		InputStream ofASe8dS = new BufferedInputStream(new FileInputStream(NMzD2GKc));
		int DyVCHz3N;
		while ((DyVCHz3N = ofASe8dS.read()) != -1)
			U2nrVzq4.write(DyVCHz3N);
		U2nrVzq4.close();
		ofASe8dS.close();
	}

}