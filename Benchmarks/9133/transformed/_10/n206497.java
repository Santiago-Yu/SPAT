class n206497 {
	public static void main(String[] args) {
		RSSReader rssreader = new RSSReader();
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			String url = args[0];
			XmlPullParser parser = factory.newPullParser();
			InputStreamReader stream = new InputStreamReader(new URL(url).openStream());
			parser.setInput(stream);
			XmlSerializer writer = factory.newSerializer();
			writer.setOutput(new OutputStreamWriter(System.out));
			rssreader.convertRSSToHtml(parser, writer);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

}