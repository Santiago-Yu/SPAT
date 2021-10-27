class n3778980 {
	public void update() {
		Vector FquXV6QU = new Vector();
		for (int cwA6P2GT = 0; cwA6P2GT < urls.size(); cwA6P2GT++) {
			URL et0SZFUR = null;
			try {
				et0SZFUR = new URL((String) urls.elementAt(cwA6P2GT));
				InputStream ecCrxQfZ = et0SZFUR.openStream();
				ecCrxQfZ.close();
			} catch (MalformedURLException x7B89ctO) {
				Logger.logWarning("Malformed URL: " + urls.elementAt(cwA6P2GT));
			} catch (IOException Zi5X9OZp) {
				FquXV6QU.addElement(et0SZFUR);
			}
		}
		for (int dthUxcvH = 0; dthUxcvH < FquXV6QU.size(); dthUxcvH++) {
			urls.removeElement(FquXV6QU.elementAt(dthUxcvH));
			Logger.logInfo("Removed " + FquXV6QU.elementAt(dthUxcvH) + " - no longer available");
		}
	}

}