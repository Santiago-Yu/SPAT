class n6781681 {
	public String expandTemplate(String OkRGZr6M) throws IOException, HttpException {
		connect();
		try {
			HttpGet D5K5VlWL = new HttpGet(contextPath + OkRGZr6M);
			HttpResponse mLs4AA1g = httpexecutor.execute(D5K5VlWL, conn);
			TolvenLogger.info("Response: " + mLs4AA1g.getStatusLine(), TemplateGen.class);
			disconnect();
			return EntityUtils.toString(mLs4AA1g.getEntity());
		} finally {
			disconnect();
		}
	}

}