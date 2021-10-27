class n15129122 {
	public void doGet(OutputStream os) throws IOException {
		try {
			uc = (HttpURLConnection) url.openConnection();
			uc.setRequestProperty("User-Agent", USER_AGENT);
			uc.setReadTimeout(READ_TIMEOUT);
			logger.debug(
					"Connect timeout=" + uc.getConnectTimeout() + " read timeout=" + uc.getReadTimeout() + " u=" + url);
			int c;
			InputStream buffer = new BufferedInputStream(uc.getInputStream());
			while ((c = buffer.read()) != -1) {
				os.write(c);
			}
			headers = uc.getHeaderFields();
			status = uc.getResponseCode();
			responseMessage = uc.getResponseMessage();
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		} finally {
			if (status != 200)
				logger.error("Download failed status: " + status + " " + responseMessage + " for " + url);
			else
				logger.debug("HTTP status=" + status + " " + uc.getResponseMessage());
			os.close();
			uc.disconnect();
		}
	}

}