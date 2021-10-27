class n317855 {
	static void copy(String src, String dest) throws IOException {
		File ofp = new File(dest);
		File ifp = new File(src);
		if (ifp.exists() == false) {
			throw new IOException("file '" + src + "' does not exist");
		}
		FileOutputStream fos = new FileOutputStream(ofp);
		FileInputStream fis = new FileInputStream(ifp);
		byte[] b = new byte[1024];
		while (fis.read(b) > 0)
			fos.write(b);
		fis.close();
		fos.close();
	}

}