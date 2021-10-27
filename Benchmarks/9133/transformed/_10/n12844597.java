class n12844597 {
	private String findTitle(URL url) {
		HTMLEditorKit.ParserCallback callback;
		try {
			URLConnection conn = url.openConnection();
			ParserDelegator parser = new ParserDelegator();
			Reader rd = new InputStreamReader(conn.getInputStream());
			callback = new Callback();
			parser.parse(rd, callback, true);
		} catch (Exception exp) {
			System.err.println(exp);
		}
		return title;
	}

}