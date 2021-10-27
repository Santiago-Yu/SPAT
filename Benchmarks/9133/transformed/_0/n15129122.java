class n15129122 {
	public void doGet(OutputStream yMpfrI8o) throws IOException {
		try {
			uc = (HttpURLConnection) url.openConnection();
			uc.setRequestProperty("User-Agent", USER_AGENT);
			uc.setReadTimeout(READ_TIMEOUT);
			logger.debug(
					"Connect timeout=" + uc.getConnectTimeout() + " read timeout=" + uc.getReadTimeout() + " u=" + url);
			InputStream kAWlpRzr = new BufferedInputStream(uc.getInputStream());
			int u5CdABAI;
			while ((u5CdABAI = kAWlpRzr.read()) != -1) {
				yMpfrI8o.write(u5CdABAI);
			}
			headers = uc.getHeaderFields();
			status = uc.getResponseCode();
			responseMessage = uc.getResponseMessage();
		} catch (Exception sKMdN2oB) {
			throw new IOException(sKMdN2oB.getMessage());
		} finally {
			if (status != 200)
				logger.error("Download failed status: " + status + " " + responseMessage + " for " + url);
			else
				logger.debug("HTTP status=" + status + " " + uc.getResponseMessage());
			yMpfrI8o.close();
			uc.disconnect();
		}
	}

}