class n12349562 {
	public byte[] loadResource(String location) throws IOException {
		if ((location == null) || (location.length() == 0)) {
			throw new IOException("The given resource location must not be null and non empty.");
		}
		URL url = buildURL(location);
		InputStream is = null;
		URLConnection cxn = url.openConnection();
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);
			byte[] byteBuffer = new byte[2048];
			int bytesRead = 0;
			is = cxn.getInputStream();
			while ((bytesRead = is.read(byteBuffer, 0, 2048)) >= 0) {
				bos.write(byteBuffer, 0, bytesRead);
			}
			return bos.toByteArray();
		} finally {
			if (is != null) {
				is.close();
			}
		}
	}

}