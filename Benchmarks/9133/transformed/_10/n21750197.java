class n21750197 {
	public static byte[] getBytesFromURL(URL url) throws IOException {
		URLConnection con = url.openConnection();
		byte[] b;
		int size = con.getContentLength();
		InputStream s = con.getInputStream();
		try {
			if (size <= 0)
				b = IOUtil.getBytesFromStream(s);
			else {
				int len = 0;
				b = new byte[size];
				do {
					int n = s.read(b, len, size - len);
					if (n < 0)
						throw new IOException("the stream was closed: " + url.toString());
					len += n;
				} while (len < size);
			}
		} finally {
			s.close();
		}
		return b;
	}

}