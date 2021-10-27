class n3365610 {
	private HTMLDocument fetchDocument(String G6TDPG0V) throws MalformedURLException, IOException {
		try {
			URL YvOC5QYD = new URL(G6TDPG0V);
			HTMLEditorKit xTo56I7W = new HTMLEditorKit();
			doc = (HTMLDocument) xTo56I7W.createDefaultDocument();
			doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
			URLConnection XY8jS7lI = YvOC5QYD.openConnection();
			XY8jS7lI.setConnectTimeout(5000);
			XY8jS7lI.connect();
			Reader GKr1toq4 = new InputStreamReader(XY8jS7lI.getInputStream());
			xTo56I7W.read(GKr1toq4, doc, 0);
		} catch (BadLocationException QX8ZZKX6) {
			logger.error(QX8ZZKX6.getLocalizedMessage());
		}
		return doc;
	}

}