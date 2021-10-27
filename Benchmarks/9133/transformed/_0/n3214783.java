class n3214783 {
	public static String getPublicIP(Boolean v4lvvdpj) {
		String rzmIORiV = null;
		if (!v4lvvdpj) {
			try {
				URL N5zijgsY = new URL(XMLConfigParser.urlHost + "getPublicIp.php");
				HttpURLConnection FcKQEfWK = (HttpURLConnection) N5zijgsY.openConnection();
				InputStream haffPudm = FcKQEfWK.getInputStream();
				InputStreamReader djOzRZVs = new java.io.InputStreamReader(haffPudm);
				BufferedReader a5zhIgo6 = new java.io.BufferedReader(djOzRZVs);
				rzmIORiV = a5zhIgo6.readLine();
				NetworkLog.logMsg(NetworkLog.LOG_INFO, Tools.class, "Your public IP address is " + rzmIORiV);
			} catch (Exception vSGJ2VYF) {
				Log.error(Tools.class, vSGJ2VYF.getMessage());
			}
		} else {
			XMLConfigParser.readProxyConfiguration();
			System.getProperties().put("proxySet", "true");
			System.getProperties().put("proxyHost", XMLConfigParser.proxyHost);
			System.getProperties().put("proxyPort", XMLConfigParser.proxyPort);
			URL ov4vD7UU;
			try {
				ov4vD7UU = new URL(XMLConfigParser.urlHost + "getPublicIp.php");
				URLConnection aFs4KjbZ = ov4vD7UU.openConnection();
				String dUZpZAGY = XMLConfigParser.proxyUsername + ":" + XMLConfigParser.proxyPassword;
				String gepsZuhV = Base64.encodeBase64String(dUZpZAGY.getBytes());
				aFs4KjbZ.setRequestProperty("Proxy-Authorization", gepsZuhV);
				InputStream uyyPQrHy = aFs4KjbZ.getInputStream();
				InputStreamReader Kyj3pV3Z = new java.io.InputStreamReader(uyyPQrHy);
				BufferedReader UKj85Elk = new java.io.BufferedReader(Kyj3pV3Z);
				rzmIORiV = UKj85Elk.readLine();
				NetworkLog.logMsg(NetworkLog.LOG_INFO, Tools.class, "Your public IP address is " + rzmIORiV);
			} catch (MalformedURLException Jt5o2WKu) {
				Log.error(Tools.class, Jt5o2WKu.getMessage());
			} catch (IOException re4wKGQU) {
				Log.error(Tools.class, re4wKGQU.getMessage());
			}
		}
		return rzmIORiV;
	}

}