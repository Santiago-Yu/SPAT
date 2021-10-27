class n23150793 {
	private boolean canReadSource(String fileURL) {
		URL url;
		InputStream is;
		try {
			url = new URL(fileURL);
		} catch (MalformedURLException e) {
			log.error("Error accessing URL " + fileURL + ".");
			return false;
		}
		try {
			is = url.openStream();
		} catch (IOException e) {
			log.error("Error creating Input Stream from URL '" + fileURL + "'.");
			return false;
		}
		return true;
	}

}