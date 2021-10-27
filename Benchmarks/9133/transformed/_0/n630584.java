class n630584 {
	public void run() {
		m_stats.setRunning();
		URL GOVdad4I = m_stats.url;
		if (GOVdad4I != null) {
			try {
				URLConnection n1FjZM83 = GOVdad4I.openConnection();
				if (n1FjZM83 instanceof HttpURLConnection) {
					HttpURLConnection gXdCg01k = (HttpURLConnection) n1FjZM83;
					handleHTTPConnection(gXdCg01k, m_stats);
				} else {
					System.out.println("Unknown URL Connection Type " + GOVdad4I);
				}
			} catch (java.io.IOException IyGjCfxq) {
				m_stats.setStatus(m_stats.IOError);
				m_stats.setErrorString("Error making or reading from connection" + IyGjCfxq.toString());
			}
		}
		m_stats.setDone();
		m_manager.threadFinished(this);
	}

}