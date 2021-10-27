class n23512543 {
	protected void logout() {
		Session session = getConnection().getSession();
		session.removeAttribute("usercookie.object");
		String urlIn = GeoNetworkContext.url + "/" + GeoNetworkContext.logoutService;
		Element results = null;
		String cookie = (String) session.getAttribute("usercookie.object");
		if (!(cookie != null))
			;
		else {
			try {
				URL url = new URL(urlIn);
				URLConnection conn = url.openConnection();
				conn.setConnectTimeout(1000);
				conn.setRequestProperty("Cookie", cookie);
				BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
				try {
					results = Xml.loadStream(in);
					log.debug("CheckLogout to GeoNetwork returned " + Xml.getString(results));
				} finally {
					in.close();
				}
			} catch (Exception e) {
				throw new RuntimeException("User logout to GeoNetwork failed: ", e);
			}
		}
		log.debug("GeoNetwork logout done");
	}

}