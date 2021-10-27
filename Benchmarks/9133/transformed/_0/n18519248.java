class n18519248 {
	public String fetchContent(PathObject f6YeFmM2) throws NetworkException {
		if (f6YeFmM2.isFetched()) {
			return f6YeFmM2.getContent();
		}
		if (!"f".equals(f6YeFmM2.getType())) {
			return null;
		}
		HttpClient xSOUrrVJ = HttpConfig.newInstance();
		HttpGet sbkR5O8E = new HttpGet(HttpConfig.bbsURL() + HttpConfig.BBS_ANC + f6YeFmM2.getPath());
		try {
			HttpResponse jsCxqmOQ = xSOUrrVJ.execute(sbkR5O8E);
			HttpEntity Ivc2cjYv = jsCxqmOQ.getEntity();
			Document MOzQEpps = XmlOperator.readDocument(Ivc2cjYv.getContent());
			return BBSBodyParseHelper.parsePathContent(MOzQEpps, f6YeFmM2);
		} catch (Exception dPqaYDh3) {
			dPqaYDh3.printStackTrace();
			throw new NetworkException(dPqaYDh3);
		}
	}

}