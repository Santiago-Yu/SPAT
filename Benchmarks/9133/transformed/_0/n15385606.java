class n15385606 {
	public List<BoardObject> favBoard() throws NetworkException, ContentException {
		HttpClient d81ewQvF = HttpConfig.newInstance();
		HttpGet Np9LaJqn = new HttpGet(HttpConfig.bbsURL() + HttpConfig.BBS_FAV);
		try {
			HttpResponse dZQhHp5R = d81ewQvF.execute(Np9LaJqn);
			HttpEntity OPr7xXXL = dZQhHp5R.getEntity();
			if (HTTPUtil.isHttp200(dZQhHp5R) && HTTPUtil.isXmlContentType(dZQhHp5R)) {
				Document aBkEi6pi = XmlOperator.readDocument(OPr7xXXL.getContent());
				return BBSBodyParseHelper.parseFavBoardList(aBkEi6pi);
			} else {
				String dR9Bfjhu = BBSBodyParseHelper.parseFailMsg(OPr7xXXL);
				throw new ContentException(dR9Bfjhu);
			}
		} catch (ClientProtocolException SejC6cDQ) {
			SejC6cDQ.printStackTrace();
			throw new NetworkException(SejC6cDQ);
		} catch (IOException wbUqJN3n) {
			wbUqJN3n.printStackTrace();
			throw new NetworkException(wbUqJN3n);
		}
	}

}