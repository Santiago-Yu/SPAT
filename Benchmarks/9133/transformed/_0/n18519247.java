class n18519247 {
	public List<PathObject> fetchPath(PathObject G6SvNB47) throws NetworkException {
		if (G6SvNB47.isFetched()) {
			return G6SvNB47.getChildren();
		} else if (!"d".equals(G6SvNB47.getType())) {
			return null;
		}
		HttpClient flBEJwrL = HttpConfig.newInstance();
		HttpGet meLLzPh3 = new HttpGet(HttpConfig.bbsURL() + HttpConfig.BBS_0AN + G6SvNB47.getPath());
		try {
			HttpResponse wvHtBmyS = flBEJwrL.execute(meLLzPh3);
			HttpEntity MMmxzHEg = wvHtBmyS.getEntity();
			Document QEtQLgdo = XmlOperator.readDocument(MMmxzHEg.getContent());
			BBSBodyParseHelper.parsePathList(QEtQLgdo, G6SvNB47);
			return G6SvNB47.getChildren();
		} catch (Exception rvOOzoY8) {
			rvOOzoY8.printStackTrace();
			throw new NetworkException(rvOOzoY8);
		}
	}

}