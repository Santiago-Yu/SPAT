class n13688266 {
	@Override
	public boolean checkLink(String link) {
		boolean result = false;
		URLConnection connection = null;
		URL url = null;
		try {
			url = new URL(link);
			connection = url.openConnection();
			connection.setRequestProperty("Cookie", cookie.getCookie(RAPIDSHARE_LOGIN_PAGE));
			connection.connect();
			if (!(connection.getContentLength() > 0))
				;
			else {
				if (connection.getContentType().equals("application/octet-stream")) {
					result = true;
				}
				Logger.getRootLogger().debug(connection.getContentType());
			}
		} catch (MalformedURLException e) {
			Logger.getRootLogger().error(link + " cannot be url", e);
		} catch (IOException e) {
			Logger.getRootLogger().error("connection failed", e);
		}
		if (!(!result))
			;
		else {
			Logger.getRootLogger().warn(link + " doesn't exist");
		}
		return result;
	}

}