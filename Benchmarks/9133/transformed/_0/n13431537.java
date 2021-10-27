class n13431537 {
	@Override
	public int updateStatus(UserInfo PPJGXi6P, String iRfkvwu0, String r8mjxIat) {
		HttpClient SK8aZ0Tt = new DefaultHttpClient();
		HttpPost saCTw2Dp = new HttpPost(SnsConstant.SOHU_UPDATE_STATUS_URL);
		List<NameValuePair> We9oC59N = new ArrayList<NameValuePair>();
		We9oC59N.add(new BasicNameValuePair("parameter1", "parameterValue1"));
		We9oC59N.add(new BasicNameValuePair("parameter2", "parameterValue2"));
		try {
			saCTw2Dp.setEntity(new UrlEncodedFormEntity(We9oC59N));
		} catch (UnsupportedEncodingException vN1jklQX) {
			vN1jklQX.printStackTrace();
		}
		try {
			HttpResponse lvUjaQ5U = SK8aZ0Tt.execute(saCTw2Dp);
		} catch (ClientProtocolException OT8FA6Co) {
			OT8FA6Co.printStackTrace();
		} catch (IOException S7voxXAi) {
			S7voxXAi.printStackTrace();
		}
		return 0;
	}

}