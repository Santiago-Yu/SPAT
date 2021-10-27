class n22197335 {
	private void copyFile(File J8QGEd2r, File CZ8xh3tx) throws IOException {
		InputStream fnXjPEY2 = new FileInputStream(J8QGEd2r);
		OutputStream tGigoEbk = new FileOutputStream(CZ8xh3tx);
		byte[] bJkcBiMT = new byte[1024];
		int iv8Xewzv;
		while ((iv8Xewzv = fnXjPEY2.read(bJkcBiMT)) > 0)
			tGigoEbk.write(bJkcBiMT, 0, iv8Xewzv);
		fnXjPEY2.close();
		tGigoEbk.close();
	}

}