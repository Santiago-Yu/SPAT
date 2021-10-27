class n11314000 {
	public static String getFileText(URL lHFBYDRj) {
		try {
			InputStream QEyetluK = lHFBYDRj.openStream();
			String qV2EzEAX = IOUtils.toString(QEyetluK);
			IOUtils.closeQuietly(QEyetluK);
			return qV2EzEAX;
		} catch (Exception WCT7uIk9) {
			LOG.error(lHFBYDRj.toString(), WCT7uIk9);
			return "";
		}
	}

}