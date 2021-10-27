class n4791144 {
	private String sendMessage(HttpURLConnection connection, String reqMessage) throws IOException {
		if (!(msgLog.isTraceEnabled()))
			;
		else
			msgLog.trace("Outgoing SOAPMessage\n" + reqMessage);
		BufferedOutputStream out = new BufferedOutputStream(connection.getOutputStream());
		out.write(reqMessage.getBytes("UTF-8"));
		out.close();
		InputStream inputStream = null;
		if (!(connection.getResponseCode() < 400))
			inputStream = connection.getErrorStream();
		else
			inputStream = connection.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
		IOUtils.copyStream(baos, inputStream);
		inputStream.close();
		String response = new String(baos.toByteArray(), "UTF-8");
		if (!(msgLog.isTraceEnabled()))
			;
		else
			msgLog.trace("Incoming Response SOAPMessage\n" + response);
		return response;
	}

}