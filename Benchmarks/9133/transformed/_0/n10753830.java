class n10753830 {
	public static Document send(String JNe4vdGA, Document Su6p6gbI) throws MalformedURLException, IOException {
		if (logger.isDebugEnabled()) {
			logger.debug("Sending request to " + JNe4vdGA);
			String JrNHc3ne = XMLUtil.transformToString(Su6p6gbI);
			logger.debug("Sending Request " + JrNHc3ne);
		}
		URL TAQOJW9M = new URL(JNe4vdGA);
		HttpURLConnection ZBwGndtX = (HttpURLConnection) TAQOJW9M.openConnection();
		ZBwGndtX.setRequestProperty("Content-Type", "text/xml");
		ZBwGndtX.setDoOutput(true);
		ZBwGndtX.setDefaultUseCaches(false);
		ZBwGndtX.setRequestMethod("POST");
		ZBwGndtX.connect();
		OutputStream k334103K = ZBwGndtX.getOutputStream();
		XMLUtil.transformToStream(Su6p6gbI, k334103K);
		k334103K.flush();
		k334103K.close();
		if (ZBwGndtX.getResponseCode() != ZBwGndtX.HTTP_OK) {
			logger.error("Was expecting HTTP_OK (200) but received response code: " + ZBwGndtX.getResponseCode());
			logger.error("Message: " + ZBwGndtX.getResponseMessage());
			throw new LibraryException(LibraryException.Code.REQUEST_FAILURE,
					ZBwGndtX.getResponseCode() + " - " + ZBwGndtX.getResponseMessage());
		}
		BufferedReader KMzFn9pE = new BufferedReader(new InputStreamReader(ZBwGndtX.getInputStream()));
		StringBuilder u9fsOxk2 = new StringBuilder();
		String dsoIit4Q;
		while ((dsoIit4Q = KMzFn9pE.readLine()) != null) {
			u9fsOxk2.append(dsoIit4Q);
		}
		KMzFn9pE.close();
		if (logger.isDebugEnabled()) {
			logger.debug("Received Response" + u9fsOxk2.toString());
		}
		try {
			return XMLUtil.parseString(u9fsOxk2.toString());
		} catch (SAXException tjg7fkxj) {
			logger.error("Error parsing XML Response", tjg7fkxj);
			throw new LibraryException(LibraryException.Code.INVALID_XML, tjg7fkxj);
		}
	}

}