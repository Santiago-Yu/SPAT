class n4164833 {
	public static void buildDeb(File TC2KP3I6, File y1JfYJO3, File WpzCqrUf) throws IOException {
		long V7CSiV8W = new Date().getTime() / 1000;
		OutputStream j1vNaRNj = new FileOutputStream(TC2KP3I6);
		j1vNaRNj.write("!<arch>\n".getBytes());
		startFileEntry(j1vNaRNj, DEBIAN_BINARY_NAME, V7CSiV8W, DEBIAN_BINARY_CONTENT.length());
		j1vNaRNj.write(DEBIAN_BINARY_CONTENT.getBytes());
		endFileEntry(j1vNaRNj, DEBIAN_BINARY_CONTENT.length());
		startFileEntry(j1vNaRNj, CONTROL_NAME, V7CSiV8W, y1JfYJO3.length());
		FileInputStream NoM4khHR = new FileInputStream(y1JfYJO3);
		byte[] Zc0lI2HY = new byte[1024];
		while (true) {
			int CZOvAFma = NoM4khHR.read(Zc0lI2HY);
			if (CZOvAFma == -1)
				break;
			j1vNaRNj.write(Zc0lI2HY, 0, CZOvAFma);
		}
		NoM4khHR.close();
		endFileEntry(j1vNaRNj, y1JfYJO3.length());
		startFileEntry(j1vNaRNj, DATA_NAME, V7CSiV8W, WpzCqrUf.length());
		FileInputStream bOycYGi1 = new FileInputStream(WpzCqrUf);
		while (true) {
			int kj9rRRd9 = bOycYGi1.read(Zc0lI2HY);
			if (kj9rRRd9 == -1)
				break;
			j1vNaRNj.write(Zc0lI2HY, 0, kj9rRRd9);
		}
		bOycYGi1.close();
		endFileEntry(j1vNaRNj, WpzCqrUf.length());
		j1vNaRNj.close();
	}

}