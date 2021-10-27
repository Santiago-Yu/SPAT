class n20676444 {
	protected byte[] bytesFromJar(String path) throws IOException {
		URL url = new URL(path);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		InputStream is = url.openStream();
		int n;
		byte[] buffer = new byte[2048];
		while ((n = is.read(buffer)) >= 0)
			baos.write(buffer, 0, n);
		is.close();
		return baos.toByteArray();
	}

}