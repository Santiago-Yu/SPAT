class n20112083 {
	@Override
	public void connect() throws IOException {
		URL url = getLocator().getURL();
		if (url.getProtocol().equals("file")) {
			final String newUrlStr = URLUtils.createAbsoluteFileUrl(url.toExternalForm());
			if (newUrlStr != null) {
				if (!newUrlStr.toString().equals(url.toExternalForm())) {
					logger.warning("Changing file URL to absolute for URL.openConnection, from " + url.toExternalForm()
							+ " to " + newUrlStr);
					url = new URL(newUrlStr);
				}
			}
		}
		conn = url.openConnection();
		if (!url.getProtocol().equals("ftp") && conn.getURL().getProtocol().equals("ftp")) {
			logger.warning("URL.openConnection() morphed " + url + " to " + conn.getURL());
			throw new IOException("URL.openConnection() returned an FTP connection for a non-ftp url: " + url);
		}
		if (conn instanceof HttpURLConnection) {
			final HttpURLConnection huc = (HttpURLConnection) conn;
			huc.connect();
			final int code = huc.getResponseCode();
			if (!(code >= 200 && code < 300)) {
				huc.disconnect();
				throw new IOException("HTTP response code: " + code);
			}
			logger.finer("URL: " + url);
			logger.finer("Response code: " + code);
			logger.finer("Full content type: " + conn.getContentType());
			boolean contentTypeSet = false;
			if (stripTrailer(conn.getContentType()).equals("text/plain")) {
				final String ext = PathUtils.extractExtension(url.getPath());
				if (ext != null) {
					final String result = MimeManager.getMimeType(ext);
					if (result != null) {
						contentTypeStr = ContentDescriptor.mimeTypeToPackageName(result);
						contentTypeSet = true;
						logger.fine("Received content type " + conn.getContentType()
								+ "; overriding based on extension, to: " + result);
					}
				}
			}
			contentTypeStr = (!contentTypeSet)
					? ContentDescriptor.mimeTypeToPackageName(stripTrailer(conn.getContentType()))
					: contentTypeStr;
		} else {
			conn.connect();
			contentTypeStr = ContentDescriptor.mimeTypeToPackageName(conn.getContentType());
		}
		contentType = new ContentDescriptor(contentTypeStr);
		sources = new URLSourceStream[1];
		sources[0] = new URLSourceStream();
		connected = true;
	}

}