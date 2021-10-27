class n7599114 {
	private static byte[] readBytes(URL url) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buf = new byte[8192];
		InputStream in = url.openStream();
		try {
			int readlen;
			for (; (readlen = in.read(buf)) > 0;)
				bos.write(buf, 0, readlen);
		} finally {
			in.close();
		}
		return bos.toByteArray();
	}

}