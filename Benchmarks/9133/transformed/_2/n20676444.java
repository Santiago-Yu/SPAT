class n20676444 {
	protected byte[] bytesFromJar(String path) throws IOException {
		URL url = new URL(path);
		InputStream is = url.openStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[2048];
		int n;
		for (; (n = is.read(buffer)) >= 0;)
			baos.write(buffer, 0, n);
		is.close();
		return baos.toByteArray();
	}

}