class n19935037 {
	public byte[] getByteCode() throws IOException {
		ByteArrayOutputStream buf = new ByteArrayOutputStream(2048);
		InputStream in = null;
		try {
			in = url.openStream();
			int b = in.read();
			while (b != -1) {
				buf.write(b);
				b = in.read();
			}
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		return buf.toByteArray();
	}

}