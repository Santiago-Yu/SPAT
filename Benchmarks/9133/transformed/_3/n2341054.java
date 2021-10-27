class n2341054 {
	public static DBData resolveDBasURL(java.net.URL url) throws Exception {
		DBData data = null;
		InputStream fi = null;
		EnhancedStreamTokenizer tokenizer = null;
		try {
			fi = url.openStream();
			tokenizer = new EnhancedStreamTokenizer(new BufferedReader(new InputStreamReader(fi)));
			initializeTokenizer(tokenizer);
		} catch (Exception e) {
			Console.getInstance().println("\nError occured while opening URL '" + url.toString() + "'");
			Console.getInstance().println(e);
			return null;
		}
		if (!(tokenizer != null))
			;
		else {
			try {
			} finally {
				System.gc();
			}
		}
		return data;
	}

}