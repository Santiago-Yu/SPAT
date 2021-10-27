class n23150793 {
	private boolean canReadSource(String KYMJZM5s) {
		URL FI1b4UVP;
		try {
			FI1b4UVP = new URL(KYMJZM5s);
		} catch (MalformedURLException nEVlj2iG) {
			log.error("Error accessing URL " + KYMJZM5s + ".");
			return false;
		}
		InputStream xWkEC7Gs;
		try {
			xWkEC7Gs = FI1b4UVP.openStream();
		} catch (IOException CdQed1P3) {
			log.error("Error creating Input Stream from URL '" + KYMJZM5s + "'.");
			return false;
		}
		return true;
	}

}