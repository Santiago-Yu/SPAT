class n4791144 {
	private String sendMessage(HttpURLConnection E2wIXWuK, String PIA4RPJH) throws IOException {
		if (msgLog.isTraceEnabled())
			msgLog.trace("Outgoing SOAPMessage\n" + PIA4RPJH);
		BufferedOutputStream KqHaLFMI = new BufferedOutputStream(E2wIXWuK.getOutputStream());
		KqHaLFMI.write(PIA4RPJH.getBytes("UTF-8"));
		KqHaLFMI.close();
		InputStream uXcx95JQ = null;
		if (E2wIXWuK.getResponseCode() < 400)
			uXcx95JQ = E2wIXWuK.getInputStream();
		else
			uXcx95JQ = E2wIXWuK.getErrorStream();
		ByteArrayOutputStream HosNuMOg = new ByteArrayOutputStream(1024);
		IOUtils.copyStream(HosNuMOg, uXcx95JQ);
		uXcx95JQ.close();
		String iFTnDVob = new String(HosNuMOg.toByteArray(), "UTF-8");
		if (msgLog.isTraceEnabled())
			msgLog.trace("Incoming Response SOAPMessage\n" + iFTnDVob);
		return iFTnDVob;
	}

}