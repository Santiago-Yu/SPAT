class n7718801 {
	protected static StringBuffer doRESTOp(String urlString) throws Exception {
		String restUrl = urlString;
		StringBuffer result = new StringBuffer();
		int p = restUrl.indexOf("://");
		URL url = null;
		if (p < 0)
			restUrl = System.getProperty("fedoragsearch.protocol") + "://"
					+ System.getProperty("fedoragsearch.hostport") + "/" + System.getProperty("fedoragsearch.path")
					+ restUrl;
		URLConnection conn = null;
		url = new URL(restUrl);
		conn = url.openConnection();
		conn.setRequestProperty("Authorization",
				"Basic " + (new BASE64Encoder()).encode((System.getProperty("fedoragsearch.fgsUserName") + ":"
						+ System.getProperty("fedoragsearch.fgsPassword")).getBytes()));
		conn.connect();
		content = null;
		String line;
		content = conn.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader((InputStream) content));
		while ((line = br.readLine()) != null)
			result.append(line);
		return result;
	}

}