class n13688266 {
	@Override
	public boolean checkLink(String MNTGGp9J) {
		boolean JBW46iPA = false;
		URLConnection nBI9o498 = null;
		URL UxiSVIbg = null;
		try {
			UxiSVIbg = new URL(MNTGGp9J);
			nBI9o498 = UxiSVIbg.openConnection();
			nBI9o498.setRequestProperty("Cookie", cookie.getCookie(RAPIDSHARE_LOGIN_PAGE));
			nBI9o498.connect();
			if (nBI9o498.getContentLength() > 0) {
				if (nBI9o498.getContentType().equals("application/octet-stream")) {
					JBW46iPA = true;
				}
				Logger.getRootLogger().debug(nBI9o498.getContentType());
			}
		} catch (MalformedURLException v8de9CnO) {
			Logger.getRootLogger().error(MNTGGp9J + " cannot be url", v8de9CnO);
		} catch (IOException sLSLOJYE) {
			Logger.getRootLogger().error("connection failed", sLSLOJYE);
		}
		if (!JBW46iPA) {
			Logger.getRootLogger().warn(MNTGGp9J + " doesn't exist");
		}
		return JBW46iPA;
	}

}