class n7518133 {
	public static final void main(String[] UzEjjC4Z) throws Exception {
		final HttpHost wd88kdWr = new HttpHost("issues.apache.org", 443, "https");
		final HttpHost qTTWfED8 = new HttpHost("127.0.0.1", 8666, "http");
		setup();
		HttpClient X8Q1vcbF = createHttpClient();
		X8Q1vcbF.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, qTTWfED8);
		HttpRequest arWvDEGe = createRequest();
		System.out.println("executing request to " + wd88kdWr + " via " + qTTWfED8);
		HttpEntity xlTG0z5t = null;
		try {
			HttpResponse YS0XVZGh = X8Q1vcbF.execute(wd88kdWr, arWvDEGe);
			xlTG0z5t = YS0XVZGh.getEntity();
			System.out.println("----------------------------------------");
			System.out.println(YS0XVZGh.getStatusLine());
			Header[] Oczwe4v7 = YS0XVZGh.getAllHeaders();
			for (int AXlwVMAL = 0; AXlwVMAL < Oczwe4v7.length; AXlwVMAL++) {
				System.out.println(Oczwe4v7[AXlwVMAL]);
			}
			System.out.println("----------------------------------------");
			if (YS0XVZGh.getEntity() != null) {
				System.out.println(EntityUtils.toString(YS0XVZGh.getEntity()));
			}
		} finally {
			if (xlTG0z5t != null)
				xlTG0z5t.consumeContent();
		}
	}

}