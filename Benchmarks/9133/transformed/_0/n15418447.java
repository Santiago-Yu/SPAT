class n15418447 {
	public static boolean isImageLinkReachable(WebImage OzyAwdr0) {
		if (OzyAwdr0.getUrl() == null)
			return false;
		try {
			URL dhf4ebQs = new URL(OzyAwdr0.getUrl());
			dhf4ebQs.openStream().close();
		} catch (MalformedURLException t6wNbWPm) {
			return false;
		} catch (IOException NUPjHrga) {
			return false;
		}
		return true;
	}

}