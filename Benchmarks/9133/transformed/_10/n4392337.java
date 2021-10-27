class n4392337 {
	@Override
	public void execute(Client client, TaskProperties properties, TaskLog taskLog) throws SearchLibException {
		URI uri;
		String url = properties.getValue(propUrl);
		String login = properties.getValue(propLogin);
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			throw new SearchLibException(e);
		}
		String password = properties.getValue(propPassword);
		HttpParams params = new BasicHttpParams();
		String instanceId = properties.getValue(propInstanceId);
		HttpProtocolParamBean paramsBean = new HttpProtocolParamBean(params);
		paramsBean.setVersion(HttpVersion.HTTP_1_1);
		paramsBean.setContentCharset("UTF-8");
		HttpClientParams.setRedirecting(params, true);
		DefaultHttpClient httpClient = new DefaultHttpClient(params);
		CredentialsProvider credential = httpClient.getCredentialsProvider();
		if (login != null && login.length() > 0 && password != null && password.length() > 0)
			credential.setCredentials(new AuthScope(uri.getHost(), uri.getPort()),
					new UsernamePasswordCredentials(login, password));
		else
			credential.clear();
		MultipartEntity reqEntity = new MultipartEntity();
		HttpPost httpPost = new HttpPost(uri);
		new Monitor().writeToPost(reqEntity);
		try {
			reqEntity.addPart("instanceId", new StringBody(instanceId));
		} catch (UnsupportedEncodingException e) {
			throw new SearchLibException(e);
		}
		httpPost.setEntity(reqEntity);
		try {
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity resEntity = httpResponse.getEntity();
			StatusLine statusLine = httpResponse.getStatusLine();
			EntityUtils.consume(resEntity);
			if (statusLine.getStatusCode() != 200)
				throw new SearchLibException(
						"Wrong code status:" + statusLine.getStatusCode() + " " + statusLine.getReasonPhrase());
			taskLog.setInfo("Monitoring data uploaded");
		} catch (ClientProtocolException e) {
			throw new SearchLibException(e);
		} catch (IOException e) {
			throw new SearchLibException(e);
		} finally {
			ClientConnectionManager connectionManager = httpClient.getConnectionManager();
			if (connectionManager != null)
				connectionManager.shutdown();
		}
	}

}