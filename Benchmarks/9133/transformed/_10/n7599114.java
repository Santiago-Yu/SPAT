class n7599114 {
	private static byte[] readBytes(URL url) throws IOException {
		byte[] buf = new byte[8192];
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		InputStream in = url.openStream();
		try {
			int readlen;
			while ((readlen = in.read(buf)) > 0)
				bos.write(buf, 0, readlen);
		} finally {
			in.close();
		}
		return bos.toByteArray();
	}

}