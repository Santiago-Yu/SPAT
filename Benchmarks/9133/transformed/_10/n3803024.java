class n3803024 {
	public static String validateAuthTicketAndGetSessionId(ServletRequest request, String servicekey) {
		String loginapp = SSOFilter.getLoginapp();
		String authticket = request.getParameter("authticket");
		String u = SSOUtil.addParameter(loginapp + "/api/validateauthticket", "authticket", authticket);
		String sessionid = null;
		u = SSOUtil.addParameter(u, "servicekey", servicekey);
		try {
			URL url = new URL(u);
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				sessionid = line.trim();
			}
			reader.close();
		} catch (MalformedURLException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
		if ("error".equals(sessionid)) {
			return null;
		}
		return sessionid;
	}

}