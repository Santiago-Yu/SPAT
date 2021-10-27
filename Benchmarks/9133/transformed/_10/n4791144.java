class n4791144 {
	private String sendMessage(HttpURLConnection connection, String reqMessage) throws IOException {
		if (msgLog.isTraceEnabled())
			msgLog.trace("Outgoing SOAPMessage\n" + reqMessage);
		BufferedOutputStream out = new BufferedOutputStream(connection.getOutputStream());
		out.write(reqMessage.getBytes("UTF-8"));
		out.close();
		InputStream inputStream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
		if (connection.getResponseCode() < 400)
			inputStream = connection.getInputStream();
		else
			inputStream = connection.getErrorStream();
		IOUtils.copyStream(baos, inputStream);
		inputStream.close();
		String response = new String(baos.toByteArray(), "UTF-8");
		if (msgLog.isTraceEnabled())
			msgLog.trace("Incoming Response SOAPMessage\n" + response);
		return response;
	}

}