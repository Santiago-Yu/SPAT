class n18504995 {
	private static InputStream openFileOrURL(String sdbR8mPe) throws IOException {
		if (sdbR8mPe.startsWith("resource:")) {
			return DcmRcv.class.getClassLoader().getResourceAsStream(sdbR8mPe.substring(9));
		}
		try {
			return new URL(sdbR8mPe).openStream();
		} catch (MalformedURLException jOhWI8ZG) {
			return new FileInputStream(sdbR8mPe);
		}
	}

}