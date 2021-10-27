class n2244282 {
	private InputStream loadSource(String cKgqZDP2) throws ClientProtocolException, IOException {
		HttpClient jdZxMfvC = new DefaultHttpClient();
		jdZxMfvC.getParams().setParameter(HTTP.USER_AGENT, "Mozilla/4.0 (compatible; MSIE 7.0b; Windows NT 6.0)");
		HttpGet fIKfoOXn = new HttpGet(cKgqZDP2);
		HttpResponse FaIZZvnD = jdZxMfvC.execute(fIKfoOXn);
		HttpEntity vGGYaWcg = FaIZZvnD.getEntity();
		return vGGYaWcg.getContent();
	}

}