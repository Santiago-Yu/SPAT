class n7458833 {
	private void copyParseFileToCodeFile() throws IOException {
		InputStream tlMzad6G = new FileInputStream(new File(filenameParse));
		OutputStream QWahodvA = new FileOutputStream(new File(filenameMisc));
		byte[] Hv5Hlz97 = new byte[1024];
		int mwz35ziV;
		while ((mwz35ziV = tlMzad6G.read(Hv5Hlz97)) > 0)
			QWahodvA.write(Hv5Hlz97, 0, mwz35ziV);
		tlMzad6G.close();
		QWahodvA.close();
	}

}