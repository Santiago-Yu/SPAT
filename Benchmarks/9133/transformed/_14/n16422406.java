class n16422406 {
	private URLConnection getServletConnection(String strServlet_name) throws MalformedURLException, IOException {
		URL urlServlet = null;
		if (null == strServlet_name) {
			urlServlet = m_Url;
		} else {
			urlServlet = new URL(m_Url, strServlet_name);
		}
		URLConnection connection = urlServlet.openConnection();
		connection.setConnectTimeout(180000);
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setUseCaches(false);
		connection.setRequestProperty("Content-Type", "application/x-java-serialized-object");
		if (m_strJsessionid != null) {
			connection.setRequestProperty("Cookie", m_strJsessionid);
		}
		return connection;
	}

}