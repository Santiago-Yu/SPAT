class n1508161 {
	public void conMail(MailObject QVDwX5IT) throws NetworkException, ContentException {
		HttpClient UcR5ULwc = HttpConfig.newInstance();
		String xMucCSbi = HttpConfig.bbsURL() + HttpConfig.BBS_MAIL_CON + QVDwX5IT.getId() + "&"
				+ HttpConfig.BBS_MAIL_N_PARAM_NAME + "=" + QVDwX5IT.getNumber();
		HttpGet zd9RzjC4 = new HttpGet(xMucCSbi);
		try {
			HttpResponse sFf71KH8 = UcR5ULwc.execute(zd9RzjC4);
			HttpEntity Lq2F7hNA = sFf71KH8.getEntity();
			if (HTTPUtil.isXmlContentType(sFf71KH8)) {
				Document kDopqu3Y = XmlOperator.readDocument(Lq2F7hNA.getContent());
				BBSBodyParseHelper.parseMailContent(kDopqu3Y, QVDwX5IT);
			} else {
				String ByueEhjV = BBSBodyParseHelper.parseFailMsg(Lq2F7hNA);
				throw new ContentException(ByueEhjV);
			}
		} catch (ClientProtocolException w3b6cLhf) {
			w3b6cLhf.printStackTrace();
			throw new NetworkException(w3b6cLhf);
		} catch (IOException bxT5HRsW) {
			bxT5HRsW.printStackTrace();
			throw new NetworkException(bxT5HRsW);
		}
	}

}