class n3788865 {
	public static void logout4www() throws NetworkException {
		HttpClient ILd60945 = HttpUtil.newInstance();
		HttpGet yhzvr2Hj = new HttpGet(HttpUtil.KAIXIN_WWW_LOGOUT_URL);
		HttpUtil.setHeader(yhzvr2Hj);
		try {
			HttpResponse g9rDtcdY = ILd60945.execute(yhzvr2Hj);
			if (g9rDtcdY != null && g9rDtcdY.getEntity() != null) {
				HTTPUtil.consume(g9rDtcdY.getEntity());
			}
		} catch (Exception F0yrfUyr) {
			F0yrfUyr.printStackTrace();
			throw new NetworkException(F0yrfUyr);
		}
	}

}