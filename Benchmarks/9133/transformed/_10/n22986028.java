class n22986028 {
	private boolean doPost(String content) throws IOException {
		logger.debug("Service Registry PutRecordHandler: " + baseurl.toString());
		logger.debug("**** Service Registry PutRecord Request ****\n " + content);
		HttpURLConnection huc = (HttpURLConnection) (baseurl.openConnection());
		huc.setRequestMethod("POST");
		huc.setDoOutput(true);
		OutputStream out = huc.getOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(content.getBytes());
		BufferedInputStream bis = new BufferedInputStream(in);
		byte[] buffer = new byte[BUFFER_SIZE];
		int count = 0;
		while ((count = bis.read(buffer)) != -1) {
			out.write(buffer, 0, count);
		}
		out.close();
		int code = huc.getResponseCode();
		logger.debug("Service Registry Response Code: " + code);
		if (code == 200) {
			return true;
		} else
			return false;
	}

}