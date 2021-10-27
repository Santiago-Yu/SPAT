class n15385608 {
	public boolean setFavBoard(List<BoardObject> yqkdoKE0) throws NetworkException, ContentException {
		HttpClient fgUUlnYY = HttpConfig.newInstance();
		HttpPost aVrxhZfo = new HttpPost(HttpConfig.bbsURL() + HttpConfig.BBS_FAV_SETTING);
		List<NameValuePair> aRamhMwq = new ArrayList<NameValuePair>();
		for (BoardObject JDi5iJRB : yqkdoKE0)
			aRamhMwq.add(new BasicNameValuePair(JDi5iJRB.getId(), "on"));
		try {
			aVrxhZfo.setEntity(new UrlEncodedFormEntity(aRamhMwq, BBSBodyParseHelper.BBS_CHARSET));
			HttpResponse r18u4W0M = fgUUlnYY.execute(aVrxhZfo);
			HttpEntity QdS82sV0 = r18u4W0M.getEntity();
			if (HTTPUtil.isHttp200(r18u4W0M) && HTTPUtil.isXmlContentType(r18u4W0M)) {
				HTTPUtil.consume(r18u4W0M.getEntity());
				return true;
			} else {
				String lQIlFToW = BBSBodyParseHelper.parseFailMsg(QdS82sV0);
				throw new ContentException(lQIlFToW);
			}
		} catch (ClientProtocolException wT0YNTv3) {
			wT0YNTv3.printStackTrace();
			throw new NetworkException(wT0YNTv3);
		} catch (IOException W3ULNQOS) {
			W3ULNQOS.printStackTrace();
			throw new NetworkException(W3ULNQOS);
		}
	}

}