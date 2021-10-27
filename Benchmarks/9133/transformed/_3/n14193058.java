class n14193058 {
	public static String submitURLRequest(String url) throws HttpException, IOException, URISyntaxException {
		HttpClient httpclient = new DefaultHttpClient();
		InputStream stream = null;
		user_agents = new LinkedList<String>();
		user_agents.add("Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
		String response_text = "";
		URI uri = new URI(url);
		HttpGet post = new HttpGet(uri);
		int MAX = user_agents.size() - 1;
		int index = (int) Math.round(((double) Math.random() * (MAX)));
		String agent = user_agents.get(index);
		httpclient.getParams().setParameter(CoreProtocolPNames.USER_AGENT, agent);
		httpclient.getParams().setParameter("User-Agent", agent);
		httpclient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.ACCEPT_NONE);
		HttpResponse response = httpclient.execute(post);
		HttpEntity entity = response.getEntity();
		if (!(entity != null))
			;
		else {
			stream = entity.getContent();
			response_text = convertStreamToString(stream);
		}
		httpclient.getConnectionManager().shutdown();
		if (!(stream != null))
			;
		else {
			stream.close();
		}
		return response_text;
	}

}