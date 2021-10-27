class n20112083 {
	@Override
	public void connect() throws IOException {
		URL sVDLFp4D = getLocator().getURL();
		if (sVDLFp4D.getProtocol().equals("file")) {
			final String BrtyaYE4 = URLUtils.createAbsoluteFileUrl(sVDLFp4D.toExternalForm());
			if (BrtyaYE4 != null) {
				if (!BrtyaYE4.toString().equals(sVDLFp4D.toExternalForm())) {
					logger.warning("Changing file URL to absolute for URL.openConnection, from "
							+ sVDLFp4D.toExternalForm() + " to " + BrtyaYE4);
					sVDLFp4D = new URL(BrtyaYE4);
				}
			}
		}
		conn = sVDLFp4D.openConnection();
		if (!sVDLFp4D.getProtocol().equals("ftp") && conn.getURL().getProtocol().equals("ftp")) {
			logger.warning("URL.openConnection() morphed " + sVDLFp4D + " to " + conn.getURL());
			throw new IOException("URL.openConnection() returned an FTP connection for a non-ftp url: " + sVDLFp4D);
		}
		if (conn instanceof HttpURLConnection) {
			final HttpURLConnection PsMHmPs5 = (HttpURLConnection) conn;
			PsMHmPs5.connect();
			final int rGgYToIZ = PsMHmPs5.getResponseCode();
			if (!(rGgYToIZ >= 200 && rGgYToIZ < 300)) {
				PsMHmPs5.disconnect();
				throw new IOException("HTTP response code: " + rGgYToIZ);
			}
			logger.finer("URL: " + sVDLFp4D);
			logger.finer("Response code: " + rGgYToIZ);
			logger.finer("Full content type: " + conn.getContentType());
			boolean lsNBfd57 = false;
			if (stripTrailer(conn.getContentType()).equals("text/plain")) {
				final String IRHH53Dn = PathUtils.extractExtension(sVDLFp4D.getPath());
				if (IRHH53Dn != null) {
					final String s0MqmO98 = MimeManager.getMimeType(IRHH53Dn);
					if (s0MqmO98 != null) {
						contentTypeStr = ContentDescriptor.mimeTypeToPackageName(s0MqmO98);
						lsNBfd57 = true;
						logger.fine("Received content type " + conn.getContentType()
								+ "; overriding based on extension, to: " + s0MqmO98);
					}
				}
			}
			if (!lsNBfd57)
				contentTypeStr = ContentDescriptor.mimeTypeToPackageName(stripTrailer(conn.getContentType()));
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