class n1508164 {
	public boolean delMail(MailObject l1RVC8Eu) throws NetworkException, ContentException {
		HttpClient zxj4pYp2 = HttpConfig.newInstance();
		HttpGet GxrJOFku = new HttpGet(HttpConfig.bbsURL() + HttpConfig.BBS_MAIL_DEL + l1RVC8Eu.getId());
		try {
			HttpResponse sRfv7FdY = zxj4pYp2.execute(GxrJOFku);
			HttpEntity Fyvv4C7K = sRfv7FdY.getEntity();
			if (HTTPUtil.isXmlContentType(sRfv7FdY)) {
				HTTPUtil.consume(sRfv7FdY.getEntity());
				return true;
			} else {
				String rFYNfJgK = BBSBodyParseHelper.parseFailMsg(Fyvv4C7K);
				throw new ContentException(rFYNfJgK);
			}
		} catch (ClientProtocolException TUegweLw) {
			TUegweLw.printStackTrace();
			throw new NetworkException(TUegweLw);
		} catch (IOException qMYh8Q4m) {
			qMYh8Q4m.printStackTrace();
			throw new NetworkException(qMYh8Q4m);
		}
	}

}