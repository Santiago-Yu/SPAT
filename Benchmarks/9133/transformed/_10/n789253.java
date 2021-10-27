class n789253 {
	static void copy(String src, String dest) throws IOException {
		File ofp = new File(dest);
		File ifp = new File(src);
		if (ifp.exists() == false) {
			throw new IOException("file '" + src + "' does not exist");
		}
		FileOutputStream fos = new FileOutputStream(ofp);
		FileInputStream fis = new FileInputStream(ifp);
		int readBytes;
		byte[] b = new byte[1024];
		while ((readBytes = fis.read(b)) > 0)
			fos.write(b, 0, readBytes);
		fis.close();
		fos.close();
	}

}