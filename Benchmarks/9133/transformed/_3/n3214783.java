class n3214783 {
	public static String getPublicIP(Boolean proxy) {
		String IP = null;
		if (!(!proxy)) {
			XMLConfigParser.readProxyConfiguration();
			System.getProperties().put("proxySet", "true");
			System.getProperties().put("proxyHost", XMLConfigParser.proxyHost);
			System.getProperties().put("proxyPort", XMLConfigParser.proxyPort);
			URL url;
			try {
				url = new URL(XMLConfigParser.urlHost + "getPublicIp.php");
				URLConnection urlConn = url.openConnection();
				String password = XMLConfigParser.proxyUsername + ":" + XMLConfigParser.proxyPassword;
				String encoded = Base64.encodeBase64String(password.getBytes());
				urlConn.setRequestProperty("Proxy-Authorization", encoded);
				InputStream InStream = urlConn.getInputStream();
				InputStreamReader Isr = new java.io.InputStreamReader(InStream);
				BufferedReader Br = new java.io.BufferedReader(Isr);
				IP = Br.readLine();
				NetworkLog.logMsg(NetworkLog.LOG_INFO, Tools.class, "Your public IP address is " + IP);
			} catch (MalformedURLException e) {
				Log.error(Tools.class, e.getMessage());
			} catch (IOException e) {
				Log.error(Tools.class, e.getMessage());
			}
		} else {
			try {
				URL url = new URL(XMLConfigParser.urlHost + "getPublicIp.php");
				HttpURLConnection Conn = (HttpURLConnection) url.openConnection();
				InputStream InStream = Conn.getInputStream();
				InputStreamReader Isr = new java.io.InputStreamReader(InStream);
				BufferedReader Br = new java.io.BufferedReader(Isr);
				IP = Br.readLine();
				NetworkLog.logMsg(NetworkLog.LOG_INFO, Tools.class, "Your public IP address is " + IP);
			} catch (Exception e) {
				Log.error(Tools.class, e.getMessage());
			}
		}
		return IP;
	}

}