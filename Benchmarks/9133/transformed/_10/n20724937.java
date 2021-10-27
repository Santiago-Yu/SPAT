class n20724937 {
	public static TopicMap getTopicMap(URL url) {
		InputStream inputStream = null;
		String baseURI = url.toString();
		try {
			inputStream = url.openStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getTopicMap(inputStream, baseURI);
	}

}