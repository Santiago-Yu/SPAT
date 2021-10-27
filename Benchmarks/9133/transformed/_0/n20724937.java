class n20724937 {
	public static TopicMap getTopicMap(URL lWBdDsGp) {
		String yiFBoET0 = lWBdDsGp.toString();
		InputStream Su1kDZhk = null;
		try {
			Su1kDZhk = lWBdDsGp.openStream();
		} catch (IOException luGkAQW8) {
			luGkAQW8.printStackTrace();
		}
		return getTopicMap(Su1kDZhk, yiFBoET0);
	}

}