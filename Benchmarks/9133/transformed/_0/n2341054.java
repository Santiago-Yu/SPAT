class n2341054 {
	public static DBData resolveDBasURL(java.net.URL zgop1eup) throws Exception {
		DBData Sfi0ybAL = null;
		InputStream cWSpv41G = null;
		EnhancedStreamTokenizer itYQiysR = null;
		try {
			cWSpv41G = zgop1eup.openStream();
			itYQiysR = new EnhancedStreamTokenizer(new BufferedReader(new InputStreamReader(cWSpv41G)));
			initializeTokenizer(itYQiysR);
		} catch (Exception xozRUi0c) {
			Console.getInstance().println("\nError occured while opening URL '" + zgop1eup.toString() + "'");
			Console.getInstance().println(xozRUi0c);
			return null;
		}
		if (itYQiysR != null) {
			try {
			} finally {
				System.gc();
			}
		}
		return Sfi0ybAL;
	}

}