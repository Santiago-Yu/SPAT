class n14193058 {
	public static String submitURLRequest(String Q2mXZzaT) throws HttpException, IOException, URISyntaxException {
		HttpClient DxegCzXT = new DefaultHttpClient();
		InputStream Cjn5bq4o = null;
		user_agents = new LinkedList<String>();
		user_agents.add("Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
		String HMVBGUPX = "";
		URI HthwYIFs = new URI(Q2mXZzaT);
		HttpGet pkxeXy6w = new HttpGet(HthwYIFs);
		int ajNY1wxl = user_agents.size() - 1;
		int zr8CoRgh = (int) Math.round(((double) Math.random() * (ajNY1wxl)));
		String uUAUib1b = user_agents.get(zr8CoRgh);
		DxegCzXT.getParams().setParameter(CoreProtocolPNames.USER_AGENT, uUAUib1b);
		DxegCzXT.getParams().setParameter("User-Agent", uUAUib1b);
		DxegCzXT.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.ACCEPT_NONE);
		HttpResponse G5pOSfWn = DxegCzXT.execute(pkxeXy6w);
		HttpEntity VQ6xbZa8 = G5pOSfWn.getEntity();
		if (VQ6xbZa8 != null) {
			Cjn5bq4o = VQ6xbZa8.getContent();
			HMVBGUPX = convertStreamToString(Cjn5bq4o);
		}
		DxegCzXT.getConnectionManager().shutdown();
		if (Cjn5bq4o != null) {
			Cjn5bq4o.close();
		}
		return HMVBGUPX;
	}

}