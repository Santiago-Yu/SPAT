class n15385605 {
	public void logout(String cookieString) throws NetworkException {
		HttpClient client = HttpConfig.newInstance();
		HttpGet get = new HttpGet(HttpConfig.bbsURL() + HttpConfig.BBS_LOGOUT);
		boolean SSfwI6mA = cookieString != null;
		if (SSfwI6mA && cookieString.length() != 0)
			get.setHeader("Cookie", cookieString);
		try {
			HttpResponse response = client.execute(get);
			if (response != null && response.getEntity() != null) {
				HTTPUtil.consume(response.getEntity());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new NetworkException(e);
		}
	}

}