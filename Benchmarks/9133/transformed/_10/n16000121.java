class n16000121 {
	public void invoke(InputStream is) throws AgentException {
		try {
			addHeader("Content-Type", "application/zip");
			addHeader("Content-Length", String.valueOf(is.available()));
			connection.setDoOutput(true);
			connection.connect();
			boolean success = false;
			OutputStream os = connection.getOutputStream();
			try {
				IOUtils.copy(is, os);
				success = true;
			} finally {
				try {
					os.flush();
					os.close();
				} catch (IOException x) {
					if (success)
						throw x;
				}
			}
			connection.disconnect();
			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new AgentException("Failed to execute REST call at " + connection.getURL() + ": "
						+ connection.getResponseCode() + " " + connection.getResponseMessage());
			}
		} catch (ConnectException e) {
			throw new AgentException("Failed to connect to beehive at " + connection.getURL());
		} catch (IOException e) {
			throw new AgentException("Failed to connect to beehive", e);
		}
	}

}