class n1995571 {
	protected Source resolveRepositoryURI(String WgRZRbRY) throws TransformerException {
		Source uqqFoIeD = null;
		try {
			if (WgRZRbRY != null) {
				URL YpMk3qRc = new URL(WgRZRbRY);
				InputStream ggjNPX9u = YpMk3qRc.openStream();
				if (ggjNPX9u != null) {
					uqqFoIeD = new StreamSource(ggjNPX9u);
				}
			} else {
				throw new TransformerException("Resource does not exist. \"" + WgRZRbRY + "\" is not accessible.");
			}
		} catch (MalformedURLException o9vLvV21) {
			throw new TransformerException("Error accessing resource using servlet context: " + WgRZRbRY, o9vLvV21);
		} catch (IOException jvoy1Haq) {
			throw new TransformerException("Unable to access resource at: " + WgRZRbRY, jvoy1Haq);
		}
		return uqqFoIeD;
	}

}