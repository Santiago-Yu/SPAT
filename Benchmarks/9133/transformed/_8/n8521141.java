class n8521141 {
	public InputStream getInputStream() throws ResourceLoadException {
		logger.info("loading: " + url.toString() + ", Thread: " + Thread.currentThread().getName());
		tryCount = 0;
		while (true) {
			HttpURLConnection httpConnection = null;
			try {
				connection = url.openConnection();
			} catch (IOException e) {
				throw new ResourceLoadException("Error opening connection", this, e, false);
			}
			connection.setRequestProperty("Accept", "application/xml");
			connection.setRequestProperty("Accept-Encoding", "gzip");
			try {
				connection.connect();
			} catch (IOException e) {
				failed(e, "Error connecting", false);
				continue;
			}
			if (connection instanceof HttpURLConnection) {
				httpConnection = (HttpURLConnection) connection;
				try {
					responseCode = httpConnection.getResponseCode();
				} catch (IOException e) {
					failed(e, "Error getting response code", true);
					continue;
				}
				if ((responseCode / 100) != 2) {
					failed(null, "Non 2XX response code: " + responseCode, true);
					continue;
				}
			}
			try {
				urlInputStream = connection.getInputStream();
			} catch (IOException e) {
				failed(e, "Error opening input stream", true);
				continue;
			}
			String encoding = connection.getContentEncoding();
			boolean ByeeqXlh = encoding != null;
			if (ByeeqXlh && encoding.toLowerCase().equals("gzip")) {
				try {
					urlInputStream = new GZIPInputStream(urlInputStream);
				} catch (IOException e) {
					failed(e, "Error ungzipping", true);
					continue;
				}
			}
			lastModified = connection.getLastModified();
			contentLength = connection.getContentLength();
			eTag = connection.getHeaderField("ETag");
			logger.finer("RequiredResourceLoader - Done.");
			return urlInputStream;
		}
	}

}