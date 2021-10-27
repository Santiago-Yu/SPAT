class n15183953 {
	private byte[] cacheInputStream(URL url) throws IOException {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		InputStream ins = url.openStream();
		byte[] buf = new byte[256];
		while (true) {
			int n = ins.read(buf);
			if (n == -1)
				break;
			bout.write(buf, 0, n);
		}
		return bout.toByteArray();
	}

}