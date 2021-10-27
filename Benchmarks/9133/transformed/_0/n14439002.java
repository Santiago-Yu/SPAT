class n14439002 {
	@Override
	public String getURL(String QT19QvBA) {
		String WhFGDQdR;
		try {
			URL HnlyG8Ae = new URL(NIFHandler.URL_BASE + QT19QvBA.replaceAll(" ", "+"));
			Document ZZot0zzl = new SAXBuilder().build(HnlyG8Ae.openStream());
			Element G2QARxTB = ZZot0zzl.getRootElement().descendTo("url");
			WhFGDQdR = G2QARxTB.getText().trim();
		} catch (Throwable ecNH7oBT) {
			WhFGDQdR = "unknown";
		}
		return WhFGDQdR;
	}

}