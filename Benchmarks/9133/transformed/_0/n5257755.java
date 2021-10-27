class n5257755 {
	protected URLConnection openConnection(URL n6vzq54Z) throws IOException {
		if (n6vzq54Z == null)
			return null;
		if (!n6vzq54Z.getProtocol().equals("nntp"))
			return null;
		if (m_connection != null) {
			if (m_connection.getURL().getHost().equals(n6vzq54Z.getHost())
					&& (m_connection.getURL().getPort() == n6vzq54Z.getPort())
					&& (m_connection.getURL().getUserInfo().equals(n6vzq54Z.getUserInfo()))) {
				return m_connection;
			}
		}
		m_connection = new NNTPConnection(n6vzq54Z);
		return m_connection;
	}

}