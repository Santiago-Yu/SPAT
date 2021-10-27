class n6700755 {
	public static final void newRead() {
		HTMLDocument html = new HTMLDocument();
		html.putProperty("IgnoreCharsetDirective", new Boolean(true));
		try {
			URL url = new URL("http://omega.rtu.lv/en/index.html");
			HTMLEditorKit kit = new HTMLEditorKit();
			kit.read(new BufferedReader(new InputStreamReader(url.openStream())), html, 0);
			Reader reader = new FileReader(html.getText(0, html.getLength()));
			List<String> links = HTMLUtils.extractLinks(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}