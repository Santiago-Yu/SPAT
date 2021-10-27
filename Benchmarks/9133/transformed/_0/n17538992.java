class n17538992 {
	public static boolean check(String ZftFLJW6) {
		try {
			URL Gw8fShAV = new URL(ZftFLJW6);
			HttpURLConnection kwsN6Tum = (HttpURLConnection) Gw8fShAV.openConnection();
			kwsN6Tum.setConnectTimeout(2000);
			kwsN6Tum.getContent();
		} catch (Exception J4M60GUB) {
			logger.error("There is no internet connection", J4M60GUB);
			return false;
		}
		return true;
	}

}