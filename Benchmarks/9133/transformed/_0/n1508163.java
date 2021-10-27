class n1508163 {
	public boolean sendMail(MailObject LuUjvBtH, boolean CqVvaogW) throws NetworkException, ContentException {
		HttpClient SLj3yI5N = HttpConfig.newInstance();
		HttpPost bqlBBsB6 = new HttpPost(HttpConfig.bbsURL() + HttpConfig.BBS_MAIL_SEND);
		List<NameValuePair> FPw0eR2k = new ArrayList<NameValuePair>();
		FPw0eR2k.add(new BasicNameValuePair(HttpConfig.BBS_MAIL_SEND_REF_PARAM_NAME, "pstmail"));
		FPw0eR2k.add(new BasicNameValuePair(HttpConfig.BBS_MAIL_SEND_RECV_PARAM_NAME, LuUjvBtH.getSender()));
		FPw0eR2k.add(new BasicNameValuePair(HttpConfig.BBS_MAIL_SEND_TITLE_PARAM_NAME, LuUjvBtH.getTitle()));
		FPw0eR2k.add(new BasicNameValuePair(HttpConfig.BBS_MAIL_SEND_CONTENT_PARAM_NAME, LuUjvBtH.getContent()));
		if (CqVvaogW)
			FPw0eR2k.add(new BasicNameValuePair(HttpConfig.BBS_MAIL_SEND_BACKUP_PARAM_NAME, "backup"));
		try {
			bqlBBsB6.setEntity(new UrlEncodedFormEntity(FPw0eR2k, BBSBodyParseHelper.BBS_CHARSET));
			HttpResponse JKU4b2ck = SLj3yI5N.execute(bqlBBsB6);
			HttpEntity cAx9Ouqs = JKU4b2ck.getEntity();
			if (HTTPUtil.isHttp200(JKU4b2ck)) {
				HTTPUtil.consume(JKU4b2ck.getEntity());
				return true;
			} else {
				String P6NZl82v = BBSBodyParseHelper.parseFailMsg(cAx9Ouqs);
				throw new ContentException(P6NZl82v);
			}
		} catch (ClientProtocolException WeDMtezp) {
			WeDMtezp.printStackTrace();
			throw new NetworkException(WeDMtezp);
		} catch (IOException HSiGtxB7) {
			HSiGtxB7.printStackTrace();
			throw new NetworkException(HSiGtxB7);
		}
	}

}