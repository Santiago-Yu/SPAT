class n7169985 {
	public static String connRemote(JSONObject rhHZeM2x, String V8jTp8Y1, List<NameValuePair> T0qGYCTo) {
		String SepbwKsj = "";
		try {
			HttpClient gZBln4sa = new DefaultHttpClient();
			HttpPost AWVYY7rR = new HttpPost(AZConstants.validateURL);
			HttpParams Z1uwj4c8 = new BasicHttpParams();
			T0qGYCTo.add(new BasicNameValuePair(AZConstants.ACTION_TYPE, V8jTp8Y1));
			T0qGYCTo.add(new BasicNameValuePair(AZConstants.PARAM, rhHZeM2x.toString()));
			AWVYY7rR.setEntity(new UrlEncodedFormEntity(T0qGYCTo));
			AWVYY7rR.setParams(Z1uwj4c8);
			HttpResponse m86lxZRn = gZBln4sa.execute(AWVYY7rR);
			SepbwKsj = EntityUtils.toString(m86lxZRn.getEntity());
		} catch (Exception naKPXHA9) {
			Log.e(TAG, naKPXHA9.toString());
		}
		return SepbwKsj;
	}

}