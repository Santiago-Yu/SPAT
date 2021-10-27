class n20192098 {
	public Object read(InputStream iTyidrKf, Map HDKXn5Jy) throws IOException, ClassNotFoundException {
		if (log.isTraceEnabled())
			log.trace("Read input stream with metadata=" + HDKXn5Jy);
		Integer UQRKfWh3 = (Integer) HDKXn5Jy.get(HTTPMetadataConstants.RESPONSE_CODE);
		String rgNTApDZ = (String) HDKXn5Jy.get(HTTPMetadataConstants.RESPONSE_CODE_MESSAGE);
		if (UQRKfWh3 != null && validResponseCodes.contains(UQRKfWh3) == false)
			throw new RuntimeException("Invalid HTTP server response [" + UQRKfWh3 + "] - " + rgNTApDZ);
		ByteArrayOutputStream Z74jUZbI = new ByteArrayOutputStream(1024);
		IOUtils.copyStream(Z74jUZbI, iTyidrKf);
		String qhcjJI60 = new String(Z74jUZbI.toByteArray(), charsetEncoding);
		if (isTraceEnabled) {
			String uyF1fuzX = DOMWriter.printNode(DOMUtils.parse(qhcjJI60), true);
			log.trace("Incoming Response SOAPMessage\n" + uyF1fuzX);
		}
		return qhcjJI60;
	}

}