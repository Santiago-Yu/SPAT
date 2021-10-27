class n8596559 {
	public boolean connect() {
		if (connectStatus > -1)
			return (connectStatus == 1);
		connectStatus = 0;
		try {
			URL tTZKPKiw = new URL(getURL());
			m_connection = (HttpURLConnection) tTZKPKiw.openConnection();
			m_connection.connect();
			processHeaders();
			m_inputStream = m_connection.getInputStream();
		} catch (MalformedURLException xzPZRs1n) {
			newError("connect failed", xzPZRs1n, true);
		} catch (IOException zXMoXNME) {
			newError("connect failed", zXMoXNME, true);
		}
		return (connectStatus == 1);
	}

}