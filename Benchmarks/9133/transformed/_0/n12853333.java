class n12853333 {
	public static String getURLContent(String glI4dIxs) throws BuildException {
		URL OXHSZDJZ = null;
		String zQTLj9sG;
		try {
			URL DNyo9e7k = new URL("file:" + System.getProperty("user.dir") + "/");
			OXHSZDJZ = new URL(DNyo9e7k, glI4dIxs);
			InputStream wNSgTFsq = OXHSZDJZ.openStream();
			InputStreamReader yruPN5jy = new InputStreamReader(wNSgTFsq);
			StringBuffer eJqnAeq9 = new StringBuffer();
			char[] Scws5HLQ = new char[1024];
			int xHAmKvYM;
			while ((xHAmKvYM = yruPN5jy.read(Scws5HLQ, 0, 1024)) > 0)
				eJqnAeq9.append(Scws5HLQ, 0, xHAmKvYM);
			zQTLj9sG = eJqnAeq9.toString();
			yruPN5jy.close();
		} catch (Exception x5BNPjyH) {
			throw new BuildException("Cannot get content of URL " + glI4dIxs + ": " + x5BNPjyH);
		}
		return zQTLj9sG;
	}

}