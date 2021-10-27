class n13713980 {
	private String sendMessage(HttpURLConnection omvFgTVH, String gi9vVzLW) throws IOException, XMLStreamException {
		if (msgLog.isTraceEnabled())
			msgLog.trace("Outgoing SOAPMessage\n" + gi9vVzLW);
		BufferedOutputStream VVCokAif = new BufferedOutputStream(omvFgTVH.getOutputStream());
		VVCokAif.write(gi9vVzLW.getBytes("UTF-8"));
		VVCokAif.close();
		InputStream GTTJv5WD = null;
		if (omvFgTVH.getResponseCode() < 400)
			GTTJv5WD = omvFgTVH.getInputStream();
		else
			GTTJv5WD = omvFgTVH.getErrorStream();
		ByteArrayOutputStream EP8J5Wdw = new ByteArrayOutputStream(1024);
		IOUtils.copyStream(EP8J5Wdw, GTTJv5WD);
		GTTJv5WD.close();
		byte[] DeZg1GPG = EP8J5Wdw.toByteArray();
		String JVwkpa4W = new String(DeZg1GPG, "UTF-8");
		if (msgLog.isTraceEnabled())
			msgLog.trace("Incoming Response SOAPMessage\n" + JVwkpa4W);
		return JVwkpa4W;
	}

}