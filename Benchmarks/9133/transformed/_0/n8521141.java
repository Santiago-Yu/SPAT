class n8521141 {
	public InputStream getInputStream() throws ResourceLoadException {
		logger.info("loading: " + url.toString() + ", Thread: " + Thread.currentThread().getName());
		tryCount = 0;
		while (true) {
			HttpURLConnection cbXrLL4w = null;
			try {
				connection = url.openConnection();
			} catch (IOException Pj58iiAG) {
				throw new ResourceLoadException("Error opening connection", this, Pj58iiAG, false);
			}
			connection.setRequestProperty("Accept", "application/xml");
			connection.setRequestProperty("Accept-Encoding", "gzip");
			try {
				connection.connect();
			} catch (IOException lIJVxkSs) {
				failed(lIJVxkSs, "Error connecting", false);
				continue;
			}
			if (connection instanceof HttpURLConnection) {
				cbXrLL4w = (HttpURLConnection) connection;
				try {
					responseCode = cbXrLL4w.getResponseCode();
				} catch (IOException EEyMIFCP) {
					failed(EEyMIFCP, "Error getting response code", true);
					continue;
				}
				if ((responseCode / 100) != 2) {
					failed(null, "Non 2XX response code: " + responseCode, true);
					continue;
				}
			}
			try {
				urlInputStream = connection.getInputStream();
			} catch (IOException v4AWUJnH) {
				failed(v4AWUJnH, "Error opening input stream", true);
				continue;
			}
			String iF3tu2Op = connection.getContentEncoding();
			if (iF3tu2Op != null && iF3tu2Op.toLowerCase().equals("gzip")) {
				try {
					urlInputStream = new GZIPInputStream(urlInputStream);
				} catch (IOException SMk6jd4Q) {
					failed(SMk6jd4Q, "Error ungzipping", true);
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