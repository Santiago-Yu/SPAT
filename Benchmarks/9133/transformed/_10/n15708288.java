class n15708288 {
	private Response postRequest(String urlString, String params) throws Exception {
		URL url = new URL(urlString);
		HttpURLConnection uc = (HttpURLConnection) url.openConnection();
		uc.setDoInput(true);
		uc.setDoOutput(true);
		uc.setUseCaches(false);
		uc.setAllowUserInteraction(false);
		uc.setRequestMethod("POST");
		uc.setRequestProperty("ContentType", "application/x-www-form-urlencoded");
		uc.setRequestProperty("User-Agent", "CytoLinkFromMJ");
		if (cookie != null)
			uc.setRequestProperty("Cookie", cookie);
		PrintStream out = new PrintStream(uc.getOutputStream());
		out.print(params);
		out.flush();
		out.close();
		uc.connect();
		String inputLine;
		StringBuffer sb = new StringBuffer();
		BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		while ((inputLine = in.readLine()) != null) {
			sb.append(inputLine + "\n");
		}
		in.close();
		Response res = new Response();
		res.content = sb.toString();
		res.contentType = uc.getHeaderField("Content-Type");
		res.cookie = uc.getHeaderField("Set-Cookie");
		return res;
	}

}