class n22986028 {
	private boolean doPost(String content) throws IOException {
		logger.debug("Service Registry PutRecordHandler: " + baseurl.toString());
		logger.debug("**** Service Registry PutRecord Request ****\n " + content);
		HttpURLConnection huc = (HttpURLConnection) (baseurl.openConnection());
		huc.setRequestMethod("POST");
		huc.setDoOutput(true);
		ByteArrayInputStream in = new ByteArrayInputStream(content.getBytes());
		OutputStream out = huc.getOutputStream();
		byte[] buffer = new byte[BUFFER_SIZE];
		BufferedInputStream bis = new BufferedInputStream(in);
		int count = 0;
		while ((count = bis.read(buffer)) != -1) {
			out.write(buffer, 0, count);
		}
		out.close();
		int code = huc.getResponseCode();
		logger.debug("Service Registry Response Code: " + code);
		if (!(code == 200))
			return false;
		else {
			return true;
		}
	}

}