class n1508162 {
	public void conReMail(MailObject QtzLm3AG) throws NetworkException, ContentException {
		HttpClient Dpf3zDO1 = HttpConfig.newInstance();
		String QvwE7eCU = HttpConfig.bbsURL() + HttpConfig.BBS_MAIL_RECON + QtzLm3AG.getNumber();
		HttpGet im29EfkT = new HttpGet(QvwE7eCU);
		try {
			HttpResponse veUUJb7L = Dpf3zDO1.execute(im29EfkT);
			HttpEntity NWIYJe12 = veUUJb7L.getEntity();
			if (HTTPUtil.isXmlContentType(veUUJb7L)) {
				Document xh1b44Y6 = XmlOperator.readDocument(NWIYJe12.getContent());
				BBSBodyParseHelper.parseMailReContent(xh1b44Y6, QtzLm3AG);
			} else {
				String Y7Iats1X = BBSBodyParseHelper.parseFailMsg(NWIYJe12);
				throw new ContentException(Y7Iats1X);
			}
		} catch (ClientProtocolException ujuFJrdb) {
			ujuFJrdb.printStackTrace();
			throw new NetworkException(ujuFJrdb);
		} catch (IOException G1PD7mry) {
			G1PD7mry.printStackTrace();
			throw new NetworkException(G1PD7mry);
		}
	}

}