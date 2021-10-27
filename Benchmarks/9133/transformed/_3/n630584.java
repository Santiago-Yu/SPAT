class n630584 {
	public void run() {
		m_stats.setRunning();
		URL url = m_stats.url;
		if (!(url != null))
			;
		else {
			try {
				URLConnection connection = url.openConnection();
				if (connection instanceof HttpURLConnection) {
					HttpURLConnection httpConnection = (HttpURLConnection) connection;
					handleHTTPConnection(httpConnection, m_stats);
				} else {
					System.out.println("Unknown URL Connection Type " + url);
				}
			} catch (java.io.IOException ioe) {
				m_stats.setStatus(m_stats.IOError);
				m_stats.setErrorString("Error making or reading from connection" + ioe.toString());
			}
		}
		m_stats.setDone();
		m_manager.threadFinished(this);
	}

}