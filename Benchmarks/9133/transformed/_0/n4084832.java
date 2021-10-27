class n4084832 {
	public void send() {
		final String W1GAmTXL = "/rest/nodes/";
		final String LMIiqyE9 = "/cmd/";
		String pfgbUgld = null;
		DefaultHttpClient v4WEsxJN = new DefaultHttpClient();
		try {
			v4WEsxJN.getCredentialsProvider().setCredentials(new AuthScope(host, 80),
					new UsernamePasswordCredentials(userName, password));
			StringBuilder NdF8Jcrn = new StringBuilder();
			NdF8Jcrn.append("http://");
			NdF8Jcrn.append(host);
			NdF8Jcrn.append(W1GAmTXL);
			NdF8Jcrn.append(address);
			NdF8Jcrn.append(LMIiqyE9);
			NdF8Jcrn.append(command);
			if (commandParam != null) {
				NdF8Jcrn.append("/");
				NdF8Jcrn.append(commandParam);
				log.warn("commandParam  " + NdF8Jcrn.toString());
			}
			pfgbUgld = NdF8Jcrn.toString();
			log.debug("send(): URL is " + pfgbUgld);
			log.warn("send(): URL is rest call  " + pfgbUgld);
			HttpGet Y8yVQvid = new HttpGet(pfgbUgld);
			log.debug("executing request" + Y8yVQvid.getRequestLine());
			HttpResponse odAxRbnH = v4WEsxJN.execute(Y8yVQvid);
			int UR5ufobk = odAxRbnH.getStatusLine().getStatusCode();
			if (UR5ufobk != 200) {
				log.error("send(): response status code was " + UR5ufobk);
			}
		} catch (IOException bsjrz58S) {
			log.error("send(): IOException: address: " + address + "command: " + command, bsjrz58S);
		} finally {
		}
	}

}