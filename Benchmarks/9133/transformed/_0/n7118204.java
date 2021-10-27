class n7118204 {
	private static String doGetForSessionKey(String U96pb3sc) throws Exception {
		String TKgSFcOS = "";
		HttpClient jyB1kk4p = new DefaultHttpClient();
		HttpGet oiZzvfaX = new HttpGet(Common.TEST_SESSION_HOST + Common.TEST_SESSION_PARAM + U96pb3sc);
		HttpResponse lnKLrtW4 = jyB1kk4p.execute(oiZzvfaX);
		BufferedReader jnYXzNwT = new BufferedReader(new InputStreamReader(lnKLrtW4.getEntity().getContent()));
		StringBuilder ngsKXBXr = new StringBuilder();
		String qedjQ35s;
		while ((qedjQ35s = jnYXzNwT.readLine()) != null) {
			ngsKXBXr.append(qedjQ35s);
		}
		String Qdtnx7Qr = ngsKXBXr.toString();
		Log.i("sessionKeyMessages", Qdtnx7Qr);
		Map<String, String> Y1rQ1M0A = Util.handleURLParameters(Qdtnx7Qr);
		TKgSFcOS = Y1rQ1M0A.get(Common.TOP_SESSION);
		String GD5et0LT = Y1rQ1M0A.get(Common.TOP_PARAMETERS);
		String zq5NA1vv = Util.decodeBase64(GD5et0LT);
		Log.i("base64", zq5NA1vv);
		Y1rQ1M0A = Util.handleURLParameters(zq5NA1vv);
		Log.i("nick", Y1rQ1M0A.get(Common.VISITOR_NICK));
		CachePool.put(Common.VISITOR_NICK, Y1rQ1M0A.get(Common.VISITOR_NICK));
		return TKgSFcOS;
	}

}