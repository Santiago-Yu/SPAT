class n3778980 {
	public void update() {
		Vector invalids = new Vector();
		int FBLkD = 0;
		while (FBLkD < urls.size()) {
			URL url = null;
			try {
				url = new URL((String) urls.elementAt(FBLkD));
				InputStream stream = url.openStream();
				stream.close();
			} catch (MalformedURLException urlE) {
				Logger.logWarning("Malformed URL: " + urls.elementAt(FBLkD));
			} catch (IOException ioE) {
				invalids.addElement(url);
			}
			FBLkD++;
		}
		int mF3aS = 0;
		while (mF3aS < invalids.size()) {
			urls.removeElement(invalids.elementAt(mF3aS));
			Logger.logInfo("Removed " + invalids.elementAt(mF3aS) + " - no longer available");
			mF3aS++;
		}
	}

}