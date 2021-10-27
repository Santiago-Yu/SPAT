class n11923843 {
	public String getLastVersion() {
		try {
			String server = icescrum2Properties.get("check.url").toString();
			Boolean useProxy = new Boolean(icescrum2Properties.get("proxy.active").toString());
			URL url = new URL(server);
			Boolean authProxy = new Boolean(icescrum2Properties.get("proxy.auth.active").toString());
			if (useProxy) {
				String proxy = icescrum2Properties.get("proxy.url").toString();
				Properties systemProperties = System.getProperties();
				String port = icescrum2Properties.get("proxy.port").toString();
				systemProperties.setProperty("http.proxyHost", proxy);
				systemProperties.setProperty("http.proxyPort", port);
			}
			URLConnection connection = url.openConnection();
			if (authProxy) {
				String username = icescrum2Properties.get("proxy.auth.username").toString();
				String password = icescrum2Properties.get("proxy.auth.password").toString();
				String login = username + ":" + password;
				String encodedLogin = Base64.base64Encode(login);
				connection.setRequestProperty("Proxy-Authorization", "Basic " + encodedLogin);
			}
			connection.setConnectTimeout(Integer.parseInt(icescrum2Properties.get("check.timeout").toString()));
			StringWriter writer = new StringWriter();
			InputStream input = connection.getInputStream();
			InputStreamReader streamReader = new InputStreamReader(input);
			String value = "";
			BufferedReader buffer = new BufferedReader(streamReader);
			while (null != (value = buffer.readLine())) {
				writer.write(value);
			}
			return writer.toString();
		} catch (IOException e) {
		}
		return null;
	}

}