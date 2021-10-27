class n160739 {
	public BufferedWriter createOutputStream(String rrScKWb6, String ENJ8dstk) throws IOException {
		int tSlP8Amk = 1024;
		int qY3l8X7m;
		char[] imTSWd21 = new char[tSlP8Amk];
		File PCTIF0ld = new File(ENJ8dstk);
		ZipOutputStream rx9ztYvx = new ZipOutputStream(new FileOutputStream(PCTIF0ld));
		rx9ztYvx.setMethod(ZipOutputStream.DEFLATED);
		OutputStreamWriter ZfMyGJ40 = new OutputStreamWriter(rx9ztYvx, "ISO-8859-1");
		BufferedWriter IyuwO5qt = new BufferedWriter(ZfMyGJ40);
		ZipEntry QYz9hFwD = null;
		File rVL7ZwJq = new File(rrScKWb6);
		ZipInputStream p67jy36i = new ZipInputStream(new FileInputStream(rVL7ZwJq));
		InputStreamReader KNnJusCz = new InputStreamReader(p67jy36i, "ISO-8859-1");
		BufferedReader fLcpkrO9 = new BufferedReader(KNnJusCz);
		ZipEntry qQ0wJxNg = null;
		while ((qQ0wJxNg = p67jy36i.getNextEntry()) != null) {
			if (qQ0wJxNg.getName().equals("content.xml")) {
				continue;
			}
			QYz9hFwD = new ZipEntry(qQ0wJxNg.getName());
			rx9ztYvx.putNextEntry(QYz9hFwD);
			while ((qY3l8X7m = fLcpkrO9.read(imTSWd21, 0, tSlP8Amk)) >= 0)
				IyuwO5qt.write(imTSWd21, 0, qY3l8X7m);
			IyuwO5qt.flush();
			rx9ztYvx.closeEntry();
		}
		rx9ztYvx.putNextEntry(new ZipEntry("content.xml"));
		IyuwO5qt.flush();
		ZfMyGJ40 = new OutputStreamWriter(rx9ztYvx, "UTF8");
		IyuwO5qt = new BufferedWriter(ZfMyGJ40);
		return IyuwO5qt;
	}

}