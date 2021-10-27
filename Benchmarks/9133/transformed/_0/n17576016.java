class n17576016 {
	public static String post(String lcKfxjEu, Map<String, String> Eg7T9jf9) {
		HttpPost dBw1LjcN = new HttpPost(lcKfxjEu);
		List<NameValuePair> vtL7ax9L = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> entry : Eg7T9jf9.entrySet()) {
			vtL7ax9L.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		try {
			dBw1LjcN.setEntity(new UrlEncodedFormEntity(vtL7ax9L, HTTP.UTF_8));
			HttpResponse i29BGAn9 = new DefaultHttpClient().execute(dBw1LjcN);
			if (i29BGAn9.getStatusLine().getStatusCode() == 200) {
				return EntityUtils.toString(i29BGAn9.getEntity());
			}
		} catch (Exception wI8wxWXR) {
			throw new RuntimeException(wI8wxWXR);
		}
		return null;
	}

}