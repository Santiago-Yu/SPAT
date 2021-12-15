class n18519248 {
	public String fetchContent(PathObject file) throws NetworkException {
		if (file.isFetched()) {
			return file.getContent();
		}
		if (!(file.getType() != null && file.getType().equals("f"))) {
			return null;
		}
		HttpClient client = HttpConfig.newInstance();
		HttpGet get = new HttpGet(HttpConfig.bbsURL() + HttpConfig.BBS_ANC + file.getPath());
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			Document doc = XmlOperator.readDocument(entity.getContent());
			return BBSBodyParseHelper.parsePathContent(doc, file);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NetworkException(e);
		}
	}

}