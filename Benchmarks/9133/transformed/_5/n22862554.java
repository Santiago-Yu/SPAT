class n22862554 {
	@Override
	public void call(String soapAction, SoapEnvelope envelope) throws IOException, XmlPullParserException {
		if (soapAction == null) {
			soapAction = "\"\"";
		}
		byte[] requestData = createRequestData(envelope);
		if (debug)
			requestDump = new String(requestData);
		else
			requestDump = null;
		responseDump = null;
		HttpPost method = new HttpPost(url);
		method.addHeader("User-Agent", "kSOAP/2.0-Excilys");
		method.addHeader("SOAPAction", soapAction);
		method.addHeader("Content-Type", "text/xml");
		HttpEntity entity = new ByteArrayEntity(requestData);
		method.setEntity(entity);
		HttpResponse response = httpClient.execute(method);
		InputStream inputStream = response.getEntity().getContent();
		if (debug) {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[256];
			while (true) {
				int rd = inputStream.read(buf, 0, 256);
				if (rd == -1) {
					break;
				}
				bos.write(buf, 0, rd);
			}
			bos.flush();
			buf = bos.toByteArray();
			responseDump = new String(buf);
			inputStream.close();
			inputStream = new ByteArrayInputStream(buf);
		}
		parseResponse(envelope, inputStream);
		inputStream.close();
	}

}