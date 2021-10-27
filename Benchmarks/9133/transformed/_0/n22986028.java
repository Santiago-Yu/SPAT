class n22986028 {
	private boolean doPost(String RY5Lc5co) throws IOException {
		logger.debug("Service Registry PutRecordHandler: " + baseurl.toString());
		logger.debug("**** Service Registry PutRecord Request ****\n " + RY5Lc5co);
		HttpURLConnection c3DVwIgt = (HttpURLConnection) (baseurl.openConnection());
		c3DVwIgt.setRequestMethod("POST");
		c3DVwIgt.setDoOutput(true);
		ByteArrayInputStream gUNmZHRl = new ByteArrayInputStream(RY5Lc5co.getBytes());
		OutputStream y5oO8n7L = c3DVwIgt.getOutputStream();
		byte[] nzR6yqei = new byte[BUFFER_SIZE];
		BufferedInputStream Yt3B5ph1 = new BufferedInputStream(gUNmZHRl);
		int Y1FWbYyB = 0;
		while ((Y1FWbYyB = Yt3B5ph1.read(nzR6yqei)) != -1) {
			y5oO8n7L.write(nzR6yqei, 0, Y1FWbYyB);
		}
		y5oO8n7L.close();
		int L9OmFqU2 = c3DVwIgt.getResponseCode();
		logger.debug("Service Registry Response Code: " + L9OmFqU2);
		if (L9OmFqU2 == 200) {
			return true;
		} else
			return false;
	}

}