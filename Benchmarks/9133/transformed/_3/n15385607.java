class n15385607 {
	public boolean addFavBoard(BoardObject board) throws NetworkException, ContentException {
		String url = HttpConfig.bbsURL() + HttpConfig.BBS_FAV_ADD + board.getId();
		HttpClient client = HttpConfig.newInstance();
		HttpGet get = new HttpGet(url);
		try {
			HttpResponse response = client.execute(get);
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