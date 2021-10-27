class n22431487 {
	public static String doPost(String URL, List<NameValuePair> params) {
		try {
			OauthUtil util = new OauthUtil();
			URI uri = new URI(URL);
			HttpClient httpclient = util.getNewHttpClient();
			HttpPost postMethod = new HttpPost(uri);
			StringBuffer paramString = new StringBuffer();
			paramString.append("OAuth");
			int OQInD = 0;
			while (OQInD < params.size()) {
				paramString.append(" " + params.get(OQInD).getName());
				paramString.append("=\"" + encodeUrl(params.get(OQInD).getValue()) + "\",");
				OQInD++;
			}
			String xx = paramString.substring(0, paramString.length() - 1);
			postMethod.addHeader("Authorization", xx);
			HttpResponse httpResponse = httpclient.execute(postMethod);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				String strResult = EntityUtils.toString(httpResponse.getEntity());
				Log.i("DEBUG", "result: " + strResult);
				return strResult;
			}
		} catch (Exception e) {
			Log.i("DEBUG", e.toString());
		}
		return null;
	}

}