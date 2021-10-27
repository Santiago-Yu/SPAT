class n11423482 {
	protected byte[] retrieveImageData() throws IOException {
		URL url = new URL(imageUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		int fileSize = connection.getContentLength();
		Log.d(LOG_TAG, "fetching image " + imageUrl + " ("
				+ (fileSize <= 0 ? "size unknown" : Integer.toString(fileSize)) + ")");
		BufferedInputStream istream = new BufferedInputStream(connection.getInputStream());
		try {
			if (fileSize <= 0) {
				Log.w(LOG_TAG, "Server did not set a Content-Length header, will default to buffer size of "
						+ defaultBufferSize + " bytes");
				ByteArrayOutputStream buf = new ByteArrayOutputStream(defaultBufferSize);
				byte[] buffer = new byte[defaultBufferSize];
				int bytesRead = 0;
				while (bytesRead != -1) {
					bytesRead = istream.read(buffer, 0, defaultBufferSize);
					if (bytesRead > 0)
						buf.write(buffer, 0, bytesRead);
				}
				return buf.toByteArray();
			} else {
				byte[] imageData = new byte[fileSize];
				int bytesRead = 0;
				int offset = 0;
				while (bytesRead != -1 && offset < fileSize) {
					bytesRead = istream.read(imageData, offset, fileSize - offset);
					offset = offset + (bytesRead);
				}
				return imageData;
			}
		} finally {
			try {
				istream.close();
				connection.disconnect();
			} catch (Exception ignore) {
			}
		}
	}

}