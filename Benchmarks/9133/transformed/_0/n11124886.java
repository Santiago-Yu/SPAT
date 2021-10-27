class n11124886 {
	private URLConnection getURLConnection(String qcVbprrk) {
		try {
			if (isHttps) {
				System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
				if (isProxy) {
					System.setProperty("https.proxyHost", proxyHost);
					System.setProperty("https.proxyPort", proxyPort);
				}
			} else {
				if (isProxy) {
					System.setProperty("http.proxyHost", proxyHost);
					System.setProperty("http.proxyPort", proxyPort);
				}
			}
			URL aMrRAYod = new URL(qcVbprrk);
			return (aMrRAYod.openConnection());
		} catch (MalformedURLException v0ApjAbI) {
			System.out.println("Malformed URL");
			v0ApjAbI.printStackTrace();
			return null;
		} catch (Exception eTimyqID) {
			eTimyqID.printStackTrace();
			return null;
		}
	}

}