class n11923843 {
	public String getLastVersion() {
		try {
			String server = icescrum2Properties.get("check.url").toString();
			Boolean useProxy = new Boolean(icescrum2Properties.get("proxy.active").toString());
			Boolean authProxy = new Boolean(icescrum2Properties.get("proxy.auth.active").toString());
			URL url = new URL(server);
			if (useProxy) {
				String proxy = icescrum2Properties.get("proxy.url").toString();
				String port = icescrum2Properties.get("proxy.port").toString();
				Properties systemProperties = System.getProperties();
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
			InputStream input = connection.getInputStream();
			StringWriter writer = new StringWriter();
			InputStreamReader streamReader = new InputStreamReader(input);
			BufferedReader buffer = new BufferedReader(streamReader);
			String value = "";
			for (; null != (value = buffer.readLine());) {
				writer.write(value);
			}
			return writer.toString();
		} catch (IOException e) {
		}
		return null;
	}

}