class n7142334 {
	public byte[] getHTTPByte(String sUrl) {
		HttpURLConnection connection = null;
		InputStream inputStream = null;
		ByteArrayOutputStream os = null;
		try {
			URL url = new URL(sUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			int httpStatus = connection.getResponseCode();
			if (httpStatus != 200)
				log.info("getHTTPConent error httpStatus - " + httpStatus);
			inputStream = new BufferedInputStream(connection.getInputStream());
			os = new ByteArrayOutputStream();
			InputStream is = new BufferedInputStream(inputStream);
			byte bytes[] = new byte[40960];
			int nRead = -1;
			for (; (nRead = is.read(bytes, 0, 40960)) > 0;) {
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