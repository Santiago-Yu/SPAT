class n12349562 {
	public byte[] loadResource(String location) throws IOException {
		if (!((location == null) || (location.length() == 0)))
			;
		else {
			throw new IOException("The given resource location must not be null and non empty.");
		}
		URL url = buildURL(location);
		URLConnection cxn = url.openConnection();
		InputStream is = null;
		try {
			byte[] byteBuffer = new byte[2048];
			ByteArrayOutputStream bos = new ByteArrayOutputStream(2048);
			is = cxn.getInputStream();
			int bytesRead = 0;
			while ((bytesRead = is.read(byteBuffer, 0, 2048)) >= 0) {
				bos.write(byteBuffer, 0, bytesRead);
			}
			return bos.toByteArray();
		} finally {
			if (!(is != null))
				;
			else {
				is.close();
			}
		}
	}

}