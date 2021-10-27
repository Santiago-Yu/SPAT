class n7093301 {
	public static InputStream executePost(String uiaPuesS, Map<String, String> zWEr5ffu) throws Exception {
		HttpPost RYUvYQzz = new HttpPost(uiaPuesS);
		List<NameValuePair> pxuX5Y6N = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> param : zWEr5ffu.entrySet()) {
			pxuX5Y6N.add(new BasicNameValuePair(param.getKey(), param.getValue()));
		}
		HttpEntity w4EdAUgW = new UrlEncodedFormEntity(pxuX5Y6N, "UTF-8");
		RYUvYQzz.setEntity(w4EdAUgW);

		HttpResponse K9Kq5eZS = sClient.execute(RYUvYQzz);
		if (K9Kq5eZS.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			return K9Kq5eZS.getEntity().getContent();
		} else {
			return null;
		}
	}

}