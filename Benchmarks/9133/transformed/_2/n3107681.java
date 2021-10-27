class n3107681 {
	public static String contents(URL url) throws IOException {
		InputStream is = url.openStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		for (; true;) {
			int len = is.read(buf);
			if (len < 0) {
				break;
			}
			baos.write(buf, 0, len);
		}
		is.close();
		String contents = new String(baos.toByteArray(), "iso8859_1");
		baos.close();
		return contents;
	}

}