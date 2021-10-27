class n5257755 {
	protected URLConnection openConnection(URL url) throws IOException {
		if (null == url)
			return null;
		if (!url.getProtocol().equals("nntp"))
			return null;
		if (m_connection != null) {
			if (m_connection.getURL().getHost().equals(url.getHost())
					&& (url.getPort() == m_connection.getURL().getPort())
					&& (m_connection.getURL().getUserInfo().equals(url.getUserInfo()))) {
				return m_connection;
			}
		}
		m_connection = new NNTPConnection(url);
		return m_connection;
	}

}