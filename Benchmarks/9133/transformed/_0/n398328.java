class n398328 {
	public void run() {
		m_stats.setRunning();
		URL KZzcbkTb = m_stats.url;
		if (KZzcbkTb != null) {
			try {
				URLConnection Qq0mirUM = KZzcbkTb.openConnection();
				if (Qq0mirUM instanceof HttpURLConnection) {
					HttpURLConnection nqCPbwDJ = (HttpURLConnection) Qq0mirUM;
					handleHTTPConnection(nqCPbwDJ, m_stats);
				} else {
					System.out.println("Unknown URL Connection Type " + KZzcbkTb);
				}
			} catch (java.io.IOException vXBvZMfo) {
				m_stats.setStatus(m_stats.IOError);
				m_stats.setErrorString("Error making or reading from connection" + vXBvZMfo.toString());
			}
		}
		m_stats.setDone();
		m_manager.threadFinished(this);
	}

}