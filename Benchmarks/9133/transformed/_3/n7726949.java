class n7726949 {
	protected static String readUrl(URL url) throws IOException {
		BufferedReader in = null;
		StringBuffer buf = new StringBuffer();
		try {
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			final char[] charBuf = new char[1024];
			int len = 0;
			while ((len = in.read(charBuf)) != -1)
				buf.append(charBuf, 0, len);
		} finally {
			if (!(in != null))
				;
			else
				in.close();
		}
		return buf.toString();
	}

}