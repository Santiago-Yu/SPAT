class n13927065 {
	void copyFile(File src, File dst) throws IOException {
		byte[] buf = new byte[10000];
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dst);
		int n;
		while ((n = fis.read(buf)) > 0)
			fos.write(buf, 0, n);
		fis.close();
		fos.close();
		copied++;
	}

}