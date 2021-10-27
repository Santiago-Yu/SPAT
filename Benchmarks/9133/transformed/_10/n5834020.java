class n5834020 {
	protected byte[] retrieveImageData() throws IOException {
		URL url = new URL(imageUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		int fileSize = connection.getContentLength();
		if (fileSize < 0) {
			return null;
		}
		BufferedInputStream istream = new BufferedInputStream(connection.getInputStream(), 8192);
		byte[] imageData = new byte[fileSize];
		int offset = 0;
		int bytesRead = 0;
		while (bytesRead != -1 && offset < fileSize) {
			bytesRead = istream.read(imageData, offset, fileSize - offset);
			offset += bytesRead;
		}
		istream.close();
		connection.disconnect();
		return imageData;
	}

}