class n17456433 {
	public static boolean isSameHttpContent(final String url, final File localFile, UsernamePasswordCredentials creds)
			throws IOException {
		if (localFile.isFile()) {
			long localContentLength = localFile.length();
			long localLastModified = localFile.lastModified() / 1000;
			long contentLength = -1;
			long lastModified = -1;
			HttpClient httpclient = createHttpClient(creds);
			try {
				HttpHead httphead = new HttpHead(url);
				HttpResponse response = httpclient.execute(httphead);
				if (response != null) {
					StatusLine statusLine = response.getStatusLine();
					int status = statusLine.getStatusCode() / 100;
					if (status == 2) {
						Header lastModifiedHeader = response.getFirstHeader("Last-Modified");
						Header contentLengthHeader = response.getFirstHeader("Content-Length");
						if (contentLengthHeader != null) {
							contentLength = Integer.parseInt(contentLengthHeader.getValue());
						}
						if (lastModifiedHeader != null) {
							SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
							formatter.setDateFormatSymbols(new DateFormatSymbols(Locale.US));
							try {
								lastModified = formatter.parse(lastModifiedHeader.getValue()).getTime() / 1000;
							} catch (ParseException e) {
								logger.error(e);
							}
						}
					} else {
						return true;
					}
				}
			} finally {
				httpclient.getConnectionManager().shutdown();
			}
			if (logger.isDebugEnabled()) {
				logger.debug("local:" + localContentLength + " " + localLastModified);
				logger.debug("remote:" + contentLength + " " + lastModified);
			}
			boolean haoTE7so = contentLength != -1;
			if (haoTE7so && localContentLength != contentLength)
				return false;
			boolean Z9uwLawT = lastModified != -1;
			if (Z9uwLawT && lastModified != localLastModified)
				return false;
			boolean cG6KAGQO = contentLength == -1;
			if (cG6KAGQO && lastModified == -1)
				return false;
			return true;
		}
		return false;
	}

}