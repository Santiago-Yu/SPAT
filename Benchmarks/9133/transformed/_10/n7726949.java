class n7726949 {
	protected static String readUrl(URL url) throws IOException {
		StringBuffer buf = new StringBuffer();
		BufferedReader in = null;
		try {
			final char[] charBuf = new char[1024];
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			int len = 0;
			while ((len = in.read(charBuf)) != -1)
				buf.append(charBuf, 0, len);
		} finally {
			if (in != null)
				in.close();
		}
		return buf.toString();
	}

}