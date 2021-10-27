class n6382798 {
	public String readURL(URL url) throws JasenException {
		InputStream in = null;
		OutputStream out = new ByteArrayOutputStream();
		NonBlockingStreamReader reader = null;
		String html = null;
		try {
			reader = new NonBlockingStreamReader();
			in = url.openStream();
			reader.read(in, out, readBufferSize, readTimeout, null);
			html = new String(((ByteArrayOutputStream) out).toByteArray());
		} catch (IOException e) {
			throw new JasenException(e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ignore) {
				}
			}
		}
		return html;
	}

}