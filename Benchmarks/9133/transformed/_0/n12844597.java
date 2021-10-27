class n12844597 {
	private String findTitle(URL K7YMf8pf) {
		HTMLEditorKit.ParserCallback Vd9TqCwq;
		try {
			URLConnection E6k9lV5F = K7YMf8pf.openConnection();
			Reader dBk0uQz7 = new InputStreamReader(E6k9lV5F.getInputStream());
			ParserDelegator lJlmWWfH = new ParserDelegator();
			Vd9TqCwq = new Callback();
			lJlmWWfH.parse(dBk0uQz7, Vd9TqCwq, true);
		} catch (Exception NSj31OcT) {
			System.err.println(NSj31OcT);
		}
		return title;
	}

}