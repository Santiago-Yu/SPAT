class n23107114 {
	private static InputStream download(String url) {
		try {
			HttpGet httpget = new HttpGet(url);
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse httpresponse = httpclient.execute(httpget);
			HttpEntity httpentity = httpresponse.getEntity();
			if (httpentity != null) {
				return httpentity.getContent();
			}
		} catch (Exception e) {
			Log.e("Android", e.getMessage());
		}
		return null;
	}

}