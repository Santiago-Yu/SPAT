class n18954577 {
	private static AndsDoiResponse doiRequest(String serviceUrl, String metaDataXML, String requestType)
			throws IOException {
		AndsDoiResponse doiResponse = null;
		if (LOG.isDebugEnabled()) {
			LOG.debug("Method URL: " + serviceUrl);
			LOG.debug("Metadata XML NULL ?: " + StringUtils.isEmpty(metaDataXML));
			LOG.debug("Request Type: " + requestType);
		}
		BufferedReader rd = null;
		OutputStreamWriter wr = null;
		URL url = new URL(serviceUrl);
		StringBuffer outputBuffer;
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		try {
			conn.setDoInput(true);
			if (requestType.equals("POST")) {
				conn.setDoOutput(true);
				wr = new OutputStreamWriter(conn.getOutputStream());
				if (metaDataXML != null) {
					wr.write("xml=" + URLEncoder.encode(metaDataXML, "UTF-8"));
				}
				wr.flush();
			} else {
				conn.setDoOutput(false);
			}
			outputBuffer = new StringBuffer();
			if (LOG.isDebugEnabled()) {
				LOG.debug(conn.getResponseCode() + " - " + conn.getResponseMessage());
			}
			outputBuffer.append(conn.getResponseMessage() + "\n");
			String line;
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			doiResponse = new AndsDoiResponse();
			while ((line = rd.readLine()) != null) {
				outputBuffer.append(line);
			}
			doiResponse.setMessage(outputBuffer.toString());
			setResponseFlag(conn.getResponseCode(), doiResponse);
		} catch (Exception e) {
			outputBuffer = new StringBuffer();
			doiResponse = new AndsDoiResponse();
			outputBuffer.append(conn.getResponseMessage() + "\n");
			String line;
			BufferedReader rde = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			while ((line = rde.readLine()) != null) {
				outputBuffer.append(line);
			}
			doiResponse.setSuccess(false);
			doiResponse.setMessage(outputBuffer.toString());
			rde.close();
		} finally {
			if (wr != null) {
				wr.close();
			}
			if (rd != null) {
				rd.close();
			}
		}
		return doiResponse;
	}

}