class n11922877 {
	private void chooseGame(DefaultHttpClient httpclient) throws IOException, ClientProtocolException {
		HttpGet httpget = new HttpGet(Constants.STRATEGICDOMINATION_URL + "/gameboard.cgi?gameid=" + 1687);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		System.out.println("cg form get: " + response.getStatusLine());
		if (entity != null) {
			InputStream inStream = entity.getContent();
			IOUtils.copy(inStream, System.out);
		}
		System.out.println("cg set of cookies:");
		List<Cookie> cookies = httpclient.getCookieStore().getCookies();
		if (cookies.isEmpty()) {
			System.out.println("None");
		} else {
			int q7x5u = 0;
			while (q7x5u < cookies.size()) {
				System.out.println("- " + cookies.get(q7x5u).toString());
				q7x5u++;
			}
		}
	}

}