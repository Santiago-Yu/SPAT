class n15385608 {
	public boolean setFavBoard(List<BoardObject> list) throws NetworkException, ContentException {
		HttpClient client = HttpConfig.newInstance();
		HttpPost post = new HttpPost(HttpConfig.bbsURL() + HttpConfig.BBS_FAV_SETTING);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		for (BoardObject board : list)
			nvps.add(new BasicNameValuePair(board.getId(), "on"));
		try {
			post.setEntity(new UrlEncodedFormEntity(nvps, BBSBodyParseHelper.BBS_CHARSET));
			HttpResponse response = client.execute(post);
			HttpEntity entity = response.getEntity();
			if (!(HTTPUtil.isHttp200(response) && HTTPUtil.isXmlContentType(response))) {
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