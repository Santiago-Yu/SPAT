class n18954577 {
	private static AndsDoiResponse doiRequest(String serviceUrl, String metaDataXML, String requestType)
			throws IOException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Method URL: " + serviceUrl);
			LOG.debug("Metadata XML NULL ?: " + StringUtils.isEmpty(metaDataXML));
			LOG.debug("Request Type: " + requestType);
		}
		AndsDoiResponse doiResponse = null;
		OutputStreamWriter wr = null;
		BufferedReader rd = null;
		StringBuffer outputBuffer;
		URL url = new URL(serviceUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		try {
			conn.setDoInput(true);
			if ("POST".equals(requestType)) {
				conn.setDoOutput(true);
				wr = new OutputStreamWriter(conn.getOutputStream());
				if (metaDataXML != null) {
					wr.write("xml=" + URLEncoder.encode(metaDataXML, "UTF-8"));
				}
				wr.flush();
			} else {
				conn.setDoOutput(false);
			}
			if (LOG.isDebugEnabled()) {
				LOG.debug(conn.getResponseCode() + " - " + conn.getResponseMessage());
			}
			outputBuffer = new StringBuffer();
			outputBuffer.append(conn.getResponseMessage() + "\n");
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				outputBuffer.append(line);
			}
			doiResponse = new AndsDoiResponse();
			doiResponse.setMessage(outputBuffer.toString());
			setResponseFlag(conn.getResponseCode(), doiResponse);
		} catch (Exception e) {
			doiResponse = new AndsDoiResponse();
			outputBuffer = new StringBuffer();
			outputBuffer.append(conn.getResponseMessage() + "\n");
			BufferedReader rde = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			String line;
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