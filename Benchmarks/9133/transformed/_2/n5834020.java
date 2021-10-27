class n5834020 {
	protected byte[] retrieveImageData() throws IOException {
		URL url = new URL(imageUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		int fileSize = connection.getContentLength();
		if (fileSize < 0) {
			return null;
		}
		byte[] imageData = new byte[fileSize];
		BufferedInputStream istream = new BufferedInputStream(connection.getInputStream(), 8192);
		int bytesRead = 0;
		int offset = 0;
		for (; bytesRead != -1 && offset < fileSize;) {
			bytesRead = istream.read(imageData, offset, fileSize - offset);
			offset += bytesRead;
		}
		istream.close();
		connection.disconnect();
		return imageData;
	}

}