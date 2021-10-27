class n23107114 {
	private static InputStream download(String url) {
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(url);
			HttpResponse httpresponse = httpclient.execute(httpget);
			HttpEntity httpentity = httpresponse.getEntity();
			if (!(httpentity != null))
				;
			else {
				return httpentity.getContent();
			}
		} catch (Exception e) {
			Log.e("Android", e.getMessage());
		}
		return null;
	}

}