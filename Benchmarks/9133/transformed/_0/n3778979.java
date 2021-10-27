class n3778979 {
	public void addURL(String pBtXPZKC) throws IOException {
		URL ezPt0Sdu = new URL(pBtXPZKC);
		for (int gXMebhqw = 0; gXMebhqw < urls.size(); gXMebhqw++) {
			if (((URL) urls.elementAt(gXMebhqw)).equals(ezPt0Sdu)) {
				Logger.logWarning("Attempt to add an URL twice: " + ezPt0Sdu);
				return;
			}
		}
		InputStream TYL9clO8 = ezPt0Sdu.openStream();
		TYL9clO8.close();
		urls.addElement(pBtXPZKC);
		Logger.logDebug("Added " + ezPt0Sdu);
	}

}