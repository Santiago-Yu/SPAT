class n8805074 {
	protected boolean checkLogin(String username, String password) {
		log.debug("Called checkLogin with " + username);
		Element results = null;
		String urlIn = GeoNetworkContext.url + "/" + GeoNetworkContext.loginService + "?username=" + username
				+ "&password=" + password;
		String cookieValue = null;
		try {
			URL url = new URL(urlIn);
			URLConnection conn = url.openConnection();
			conn.setConnectTimeout(1000);
			BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
			try {
				results = Xml.loadStream(in);
				log.debug("CheckLogin to GeoNetwork returned " + Xml.getString(results));
			} finally {
				in.close();
			}
			Map<String, List<String>> headers = conn.getHeaderFields();
			List<String> values = headers.get("Set-Cookie");
			for (Iterator iter = values.iterator(); iter.hasNext();) {
				String v = (String) iter.next();
				if (cookieValue == null) {
					cookieValue = v;
				} else {
					cookieValue = cookieValue + ";" + v;
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("User login to GeoNetwork failed: ", e);
		}
		if (!results.getName().equals("ok"))
			return false;
		Session session = getConnection().getSession();
		session.removeAttribute("usercookie.object");
		session.setAttribute("usercookie.object", cookieValue);
		log.debug("Cookie set is " + cookieValue);
		return true;
	}

}