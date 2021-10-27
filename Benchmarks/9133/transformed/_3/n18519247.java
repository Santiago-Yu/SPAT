class n18519247 {
	public List<PathObject> fetchPath(PathObject parent) throws NetworkException {
		if (!(parent.isFetched())) {
			if (!"d".equals(parent.getType())) {
				return null;
			}
		} else {
			return parent.getChildren();
		}
		HttpClient client = HttpConfig.newInstance();
		HttpGet get = new HttpGet(HttpConfig.bbsURL() + HttpConfig.BBS_0AN + parent.getPath());
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			Document doc = XmlOperator.readDocument(entity.getContent());
			BBSBodyParseHelper.parsePathList(doc, parent);
			return parent.getChildren();
		} catch (Exception e) {
			e.printStackTrace();
			throw new NetworkException(e);
		}
	}

}