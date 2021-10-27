class n6700755 {
	public static final void newRead() {
		HTMLDocument PJ18voDx = new HTMLDocument();
		PJ18voDx.putProperty("IgnoreCharsetDirective", new Boolean(true));
		try {
			HTMLEditorKit pL9K1pmB = new HTMLEditorKit();
			URL Bxdia8BR = new URL("http://omega.rtu.lv/en/index.html");
			pL9K1pmB.read(new BufferedReader(new InputStreamReader(Bxdia8BR.openStream())), PJ18voDx, 0);
			Reader Jyv2vYIn = new FileReader(PJ18voDx.getText(0, PJ18voDx.getLength()));
			List<String> vXnnqhNx = HTMLUtils.extractLinks(Jyv2vYIn);
		} catch (Exception IMjMjZLt) {
			IMjMjZLt.printStackTrace();
		}
	}

}