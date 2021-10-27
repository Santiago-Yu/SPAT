class n7142334 {
	public byte[] getHTTPByte(String sUrl) {
		InputStream inputStream = null;
		HttpURLConnection connection = null;
		ByteArrayOutputStream os = null;
		try {
			URL url = new URL(sUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			int httpStatus = connection.getResponseCode();
			if (httpStatus != 200)
				log.info("getHTTPConent error httpStatus - " + httpStatus);
			os = new ByteArrayOutputStream();
			inputStream = new BufferedInputStream(connection.getInputStream());
			byte bytes[] = new byte[40960];
			InputStream is = new BufferedInputStream(inputStream);
			int nRead = -1;
			while ((nRead = is.read(bytes, 0, 40960)) > 0) {
				os.write(bytes, 0, nRead);
			}
			os.close();
			is.close();
			inputStream.close();
		} catch (IOException e) {
			log.warn("SpiderUtil getHTTPConent IOException -> ", e);
		} finally {
			if (inputStream != null)
				try {
					os.close();
					inputStream.close();
				} catch (IOException e) {
				}
		}
		return os.toByteArray();
	}

}