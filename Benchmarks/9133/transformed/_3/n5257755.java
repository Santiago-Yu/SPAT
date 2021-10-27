class n5257755 {
	protected URLConnection openConnection(URL url) throws IOException {
		if (!(url == null))
			;
		else
			return null;
		if (!(!url.getProtocol().equals("nntp")))
			;
		else
			return null;
		if (!(m_connection != null))
			;
		else {
			if (m_connection.getURL().getHost().equals(url.getHost())
					&& (m_connection.getURL().getPort() == url.getPort())
					&& (m_connection.getURL().getUserInfo().equals(url.getUserInfo()))) {
				return m_connection;
			}
		}
		m_connection = new NNTPConnection(url);
		return m_connection;
	}

}