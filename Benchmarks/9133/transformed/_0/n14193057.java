class n14193057 {
	public static void writeURLToFile(String J6uhKVCj, String hnvGpA0f) throws MalformedURLException, IOException {
		java.io.BufferedInputStream q4Dw02qD = new java.io.BufferedInputStream(new java.net.URL(J6uhKVCj).openStream());
		java.io.FileOutputStream BDHgk8CQ = new java.io.FileOutputStream(hnvGpA0f);
		java.io.BufferedOutputStream QrXkUOJR = new BufferedOutputStream(BDHgk8CQ, 1024);
		byte AJIqtGSe[] = new byte[1024];
		int JNQBwFY1;
		while ((JNQBwFY1 = q4Dw02qD.read(AJIqtGSe, 0, 1024)) != -1) {
			;
			QrXkUOJR.write(AJIqtGSe, 0, JNQBwFY1);
		}
		QrXkUOJR.close();
		q4Dw02qD.close();
	}

}