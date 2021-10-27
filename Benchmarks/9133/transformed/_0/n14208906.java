class n14208906 {
	private void logoutUser(String ObwV92Mi) {
		try {
			String JrhYj88q = URLEncoder.encode("SESSION", "UTF-8") + "=" + URLEncoder.encode("" + ObwV92Mi, "UTF-8");
			if (_log != null)
				_log.error("Voice: logoutUser = " + m_strUrl + "LogoutUserServlet&" + JrhYj88q);
			URL el9C1JUD = new URL(m_strUrl + "LogoutUserServlet");
			URLConnection IYPV3qjh = el9C1JUD.openConnection();
			IYPV3qjh.setDoOutput(true);
			OutputStreamWriter c6R4MmQz = new OutputStreamWriter(IYPV3qjh.getOutputStream());
			c6R4MmQz.write(JrhYj88q);
			c6R4MmQz.flush();
			BufferedReader N6FfaHiq = new BufferedReader(new InputStreamReader(IYPV3qjh.getInputStream()));
			c6R4MmQz.close();
			N6FfaHiq.close();
		} catch (Exception e8zHT9HQ) {
			if (_log != null)
				_log.error("Voice error : " + e8zHT9HQ);
		}
	}

}