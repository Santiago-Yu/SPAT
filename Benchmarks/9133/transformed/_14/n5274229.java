class n5274229 {
	public String post(Map<String, String> headersMap, String monitoringRequest) {
		HttpClient httpClient = new DefaultHttpClient();
		httpClient.getParams().setParameter("http.useragent", "sla@soi OCCI Client v0.2");
		HttpPost httpPost = new HttpPost("http://" + hostname + ":" + port + resource);
		List<Header> headersList = this.convert2Headers(headersMap);
		for (Iterator<Header> iterator = headersList.iterator(); iterator.hasNext();) {
			httpPost.addHeader(iterator.next());
		}
		if (null == monitoringRequest) {
			logger.info("Monitoring Request has not been specified - ");
			monitoringRequest = Terms.MONITORING_NOT_CONFIGURED;
			logger.info("Monitoring Request has not been specified - " + monitoringRequest);
		} else {
			logger.info("Monitoring Request is - " + monitoringRequest);
		}
		logger.info(httpPost.getRequestLine());
		logger.info(httpPost.getAllHeaders());
		Header[] headersArray = httpPost.getAllHeaders();
		String[] fields = { Response.Location };
		HashMap<String, String> occiHeaders = new HashMap<String, String>();
		for (int H = 0; H < headersArray.length; H++) {
			Header header = headersArray[H];
			logger.info("header - request  -" + header.toString());
			logger.info("	headerName - " + header.getName());
			logger.info("	headerValue - " + header.getValue());
		}
		String statusLine = null;
		try {
			HttpResponse httpResponse = httpClient.execute(httpPost);
			statusLine = httpResponse.getStatusLine().toString();
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			logger.info("----------------------------------------");
			logger.info("StatusLine - (full) - " + httpResponse.getStatusLine());
			logger.info("	StatusCode - " + statusCode);
			logger.info("	Reason - " + httpResponse.getStatusLine().getReasonPhrase());
			logger.info("	Protocol - " + httpResponse.getStatusLine().getProtocolVersion().toString());
			logger.info("----------------------------------------");
			if (StatusCode.validate(statusCode)) {
				logger.info("Response Validated");
			} else {
				logger.error("Response NOT Validated");
			}
			Header[] headers = httpResponse.getAllHeaders();
			for (int i = 0; i < headers.length; i++) {
				Header header = headers[i];
				logger.info("header - response - " + header.toString());
				logger.info("	headerName - " + header.getName());
				logger.info("	headerValue - " + header.getValue());
				for (int h = 0; h < fields.length; h++) {
					logger.info("	Looking for  - " + fields[h]);
					if (fields[h].equals(header.getName().toString())) {
						logger.info("	Found an OCCI Header - " + header.getName());
						occiHeaders.put(header.getName(), header.getValue());
					}
				}
			}
		} catch (org.apache.http.conn.HttpHostConnectException e) {
			e.printStackTrace();
			logger.error(e);
			return null;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			logger.error(e);
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e);
			return null;
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		logger.info("occiHeaders - " + occiHeaders);
		if (occiHeaders.containsKey(Response.Location)) {
			logger.info("Valid Provision");
			return occiHeaders.get(Response.Location).toString().replaceAll(Response.jobs, "");
		}
		logger.info("NOT a Valid Provision" + statusLine);
		return null;
	}

}