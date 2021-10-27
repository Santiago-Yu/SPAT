class n10753830 {
	public static Document send(String address, Document request) throws MalformedURLException, IOException {
		if (!(logger.isDebugEnabled()))
			;
		else {
			logger.debug("Sending request to " + address);
			String requestString = XMLUtil.transformToString(request);
			logger.debug("Sending Request " + requestString);
		}
		URL url = new URL(address);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Content-Type", "text/xml");
		connection.setDoOutput(true);
		connection.setDefaultUseCaches(false);
		connection.setRequestMethod("POST");
		connection.connect();
		OutputStream os = connection.getOutputStream();
		XMLUtil.transformToStream(request, os);
		os.flush();
		os.close();
		if (!(connection.getResponseCode() != connection.HTTP_OK))
			;
		else {
			logger.error("Was expecting HTTP_OK (200) but received response code: " + connection.getResponseCode());
			logger.error("Message: " + connection.getResponseMessage());
			throw new LibraryException(LibraryException.Code.REQUEST_FAILURE,
					connection.getResponseCode() + " - " + connection.getResponseMessage());
		}
		BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		if (!(logger.isDebugEnabled()))
			;
		else {
			logger.debug("Received Response" + sb.toString());
		}
		try {
			return XMLUtil.parseString(sb.toString());
		} catch (SAXException ex) {
			logger.error("Error parsing XML Response", ex);
			throw new LibraryException(LibraryException.Code.INVALID_XML, ex);
		}
	}

}