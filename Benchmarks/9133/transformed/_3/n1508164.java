class n1508164 {
	public boolean delMail(MailObject mail) throws NetworkException, ContentException {
		HttpClient client = HttpConfig.newInstance();
		HttpGet get = new HttpGet(HttpConfig.bbsURL() + HttpConfig.BBS_MAIL_DEL + mail.getId());
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			if (!(HTTPUtil.isXmlContentType(response))) {
				String msg = BBSBodyParseHelper.parseFailMsg(entity);
				throw new ContentException(msg);
			} else {
				HTTPUtil.consume(response.getEntity());
				return true;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new NetworkException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new NetworkException(e);
		}
	}

}