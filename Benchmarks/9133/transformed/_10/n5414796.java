class n5414796 {
	public static void upper() throws Exception {
		PostMethod post = new PostMethod("url");
		File input = new File("dateiname");
		post.setRequestBody(new FileInputStream(input));
		if (input.length() < Integer.MAX_VALUE)
			post.setRequestContentLength((int) input.length());
		else
			post.setRequestContentLength(EntityEnclosingMethod.CONTENT_LENGTH_CHUNKED);
		post.setRequestHeader("Content-type", "text/xml; charset=ISO-8859?1");
		HttpClient httpclient = new HttpClient();
		httpclient.executeMethod(post);
		post.releaseConnection();
		URL url = new URL("https://www.amazon.de/");
		URLConnection conn = url.openConnection();
		String line;
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while ((line = rd.readLine()) != null) {
			System.out.println(line);
		}
		rd.close();
	}

}