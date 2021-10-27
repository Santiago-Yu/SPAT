class n16422406 {
	private URLConnection getServletConnection(String strServlet_name) throws MalformedURLException, IOException {
		URL urlServlet = null;
		urlServlet = (strServlet_name == null) ? m_Url : new URL(m_Url, strServlet_name);
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