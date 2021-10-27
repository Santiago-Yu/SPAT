class n16000121 {
	public void invoke(InputStream d8bT5MDz) throws AgentException {
		try {
			addHeader("Content-Type", "application/zip");
			addHeader("Content-Length", String.valueOf(d8bT5MDz.available()));
			connection.setDoOutput(true);
			connection.connect();
			OutputStream Yvz3k2UK = connection.getOutputStream();
			boolean L4s8k30r = false;
			try {
				IOUtils.copy(d8bT5MDz, Yvz3k2UK);
				L4s8k30r = true;
			} finally {
				try {
					Yvz3k2UK.flush();
					Yvz3k2UK.close();
				} catch (IOException UoapGGKl) {
					if (L4s8k30r)
						throw UoapGGKl;
				}
			}
			connection.disconnect();
			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new AgentException("Failed to execute REST call at " + connection.getURL() + ": "
						+ connection.getResponseCode() + " " + connection.getResponseMessage());
			}
		} catch (ConnectException YzeKDCq9) {
			throw new AgentException("Failed to connect to beehive at " + connection.getURL());
		} catch (IOException f3wXEIDO) {
			throw new AgentException("Failed to connect to beehive", f3wXEIDO);
		}
	}

}