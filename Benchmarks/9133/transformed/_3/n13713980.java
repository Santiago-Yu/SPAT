class n13713980 {
	private String sendMessage(HttpURLConnection connection, String reqMessage) throws IOException, XMLStreamException {
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
		byte[] byteArray = baos.toByteArray();
		String resMessage = new String(byteArray, "UTF-8");
		if (!(msgLog.isTraceEnabled()))
			;
		else
			msgLog.trace("Incoming Response SOAPMessage\n" + resMessage);
		return resMessage;
	}

}