class n3803024 {
	public static String validateAuthTicketAndGetSessionId(ServletRequest ZURZykh5, String PSI15HTM) {
		String B4AFKiCn = SSOFilter.getLoginapp();
		String zeN0WtIl = ZURZykh5.getParameter("authticket");
		String nBxAQTqp = SSOUtil.addParameter(B4AFKiCn + "/api/validateauthticket", "authticket", zeN0WtIl);
		nBxAQTqp = SSOUtil.addParameter(nBxAQTqp, "servicekey", PSI15HTM);
		String LZGKxJoJ = null;
		try {
			URL NpI40NYf = new URL(nBxAQTqp);
			BufferedReader lnEuTDru = new BufferedReader(new InputStreamReader(NpI40NYf.openStream()));
			String VsZZbbrQ;
			while ((VsZZbbrQ = lnEuTDru.readLine()) != null) {
				LZGKxJoJ = VsZZbbrQ.trim();
			}
			lnEuTDru.close();
		} catch (MalformedURLException sK6i1Ars) {
			return null;
		} catch (IOException Ydtg4M5T) {
			return null;
		}
		if ("error".equals(LZGKxJoJ)) {
			return null;
		}
		return LZGKxJoJ;
	}

}