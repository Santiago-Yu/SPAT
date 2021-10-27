class n6158569 {
	public ByteArrayOutputStream download(final String contentUuid) throws WebServiceClientException {
		try {
			URL url = new URL(getPath("/download/" + contentUuid));
			URLConnection connection = url.openConnection();
			InputStream inputStream = connection.getInputStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			int c;
			for (; (c = inputStream.read()) != -1;) {
				outputStream.write(c);
			}
			inputStream.close();
			return outputStream;
		} catch (Exception ex) {
			throw new WebServiceClientException("Could not download content from web service.", ex);
		}
	}

}