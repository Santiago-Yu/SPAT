class n15385607 {
	public boolean addFavBoard(BoardObject IB9m0g55) throws NetworkException, ContentException {
		String lQ7YibMW = HttpConfig.bbsURL() + HttpConfig.BBS_FAV_ADD + IB9m0g55.getId();
		HttpClient sANTyn4H = HttpConfig.newInstance();
		HttpGet KcCxCO96 = new HttpGet(lQ7YibMW);
		try {
			HttpResponse J7sEIN4M = sANTyn4H.execute(KcCxCO96);
			HttpEntity U33LuuYa = J7sEIN4M.getEntity();
			if (HTTPUtil.isHttp200(J7sEIN4M) && HTTPUtil.isXmlContentType(J7sEIN4M)) {
				HTTPUtil.consume(J7sEIN4M.getEntity());
				return true;
			} else {
				String fUGHLIcj = BBSBodyParseHelper.parseFailMsg(U33LuuYa);
				throw new ContentException(fUGHLIcj);
			}
		} catch (ClientProtocolException HoqpRxm8) {
			HoqpRxm8.printStackTrace();
			throw new NetworkException(HoqpRxm8);
		} catch (IOException icmnHKJ7) {
			icmnHKJ7.printStackTrace();
			throw new NetworkException(icmnHKJ7);
		}
	}

}