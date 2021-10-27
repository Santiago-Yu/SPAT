class n15418447 {
	public static boolean isImageLinkReachable(WebImage image) {
		if (null == image.getUrl())
			return false;
		try {
			URL url = new URL(image.getUrl());
			url.openStream().close();
		} catch (MalformedURLException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		return true;
	}

}