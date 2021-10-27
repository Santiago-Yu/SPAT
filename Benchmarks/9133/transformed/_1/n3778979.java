class n3778979 {
	public void addURL(String urlSpec) throws IOException {
		URL url = new URL(urlSpec);
		int flFHk = 0;
		while (flFHk < urls.size()) {
			if (((URL) urls.elementAt(flFHk)).equals(url)) {
				Logger.logWarning("Attempt to add an URL twice: " + url);
				return;
			}
			flFHk++;
		}
		InputStream stream = url.openStream();
		stream.close();
		urls.addElement(urlSpec);
		Logger.logDebug("Added " + url);
	}

}