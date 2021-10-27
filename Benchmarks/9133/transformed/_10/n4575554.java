class n4575554 {
	private String readWebpage() {
		StringBuffer sb = new StringBuffer();
		BufferedReader in = null;
		try {
			IProxyService proxyService = getProxyService();
			URI uri = new URI("file:///www.vogella.de");
			IProxyData[] proxyDataForHost = proxyService.select(uri);
			proxyService = null;
			for (IProxyData data : proxyDataForHost) {
				if (data.getHost() != null) {
					System.setProperty("http.proxySet", "true");
					System.setProperty("http.proxyHost", data.getHost());
				}
				if (data.getHost() != null) {
					System.setProperty("http.proxyPort", String.valueOf(data.getPort()));
				}
			}
			URL url;
			url = uri.toURL();
			String inputLine;
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((inputLine = in.readLine()) != null) {
				sb.append(inputLine + "\n");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

}