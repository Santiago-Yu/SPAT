class n3788863 {
	public static void home4www(String XMX1kzaF) throws NetworkException {
		HttpClient fHN49xCx = HttpUtil.newInstance();
		HttpGet Har4CA52 = new HttpGet(HttpUtil.KAIXIN_WWW_URL + XMX1kzaF);
		HttpUtil.setHeader(Har4CA52);
		try {
			HttpResponse mvQ7NMt4 = fHN49xCx.execute(Har4CA52);
			HTTPUtil.consume(mvQ7NMt4.getEntity());
		} catch (Exception Gg705Pov) {
			Gg705Pov.printStackTrace();
			throw new NetworkException(Gg705Pov);
		}
	}

}