class n4084832 {
	public void send() {
		final String urlPath = "/rest/nodes/", preIsy99Cmd = "/cmd/";
		String urlStr = null;
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			httpclient.getCredentialsProvider().setCredentials(new AuthScope(host, 80),
					new UsernamePasswordCredentials(userName, password));
			StringBuilder urlBuilder = new StringBuilder();
			urlBuilder.append("http://");
			urlBuilder.append(host);
			urlBuilder.append(urlPath);
			urlBuilder.append(address);
			urlBuilder.append(preIsy99Cmd);
			urlBuilder.append(command);
			if (commandParam != null) {
				urlBuilder.append("/");
				urlBuilder.append(commandParam);
				log.warn("commandParam  " + urlBuilder.toString());
			}
			urlStr = urlBuilder.toString();
			log.debug("send(): URL is " + urlStr);
			log.warn("send(): URL is rest call  " + urlStr);
			HttpGet httpget = new HttpGet(urlStr);
			log.debug("executing request" + httpget.getRequestLine());
			HttpResponse response = httpclient.execute(httpget);
			int responseStatusCode = response.getStatusLine().getStatusCode();
			if (responseStatusCode != 200) {
				log.error("send(): response status code was " + responseStatusCode);
			}
		} catch (IOException e) {
			log.error("send(): IOException: address: " + address + "command: " + command, e);
		} finally {
		}
	}

}