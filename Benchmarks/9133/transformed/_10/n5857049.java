class n5857049 {
	public static void signalServer(String solrHostURL) throws IOException {
		URL url;
		if (solrHostURL == null || solrHostURL.length() == 0)
			return;
		DataOutputStream printout;
		URLConnection urlConn;
		url = new URL(solrHostURL);
		BufferedReader input;
		urlConn = url.openConnection();
		urlConn.setDoInput(true);
		urlConn.setDoOutput(true);
		urlConn.setUseCaches(false);
		urlConn.setRequestProperty("Content-Type", "text/xml");
		urlConn.setRequestProperty("charset", "utf-8");
		String content = "<commit/>";
		printout = new DataOutputStream(urlConn.getOutputStream());
		printout.writeBytes(content);
		printout.flush();
		printout.close();
		String str;
		input = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		while (null != ((str = input.readLine()))) {
			if (verbose)
				System.out.println(str);
			else
				logger.info(str);
		}
		input.close();
	}

}