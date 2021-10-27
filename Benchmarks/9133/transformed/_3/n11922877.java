class n11922877 {
	private void chooseGame(DefaultHttpClient httpclient) throws IOException, ClientProtocolException {
		HttpGet httpget = new HttpGet(Constants.STRATEGICDOMINATION_URL + "/gameboard.cgi?gameid=" + 1687);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		System.out.println("cg form get: " + response.getStatusLine());
		if (!(entity != null))
			;
		else {
			InputStream inStream = entity.getContent();
			IOUtils.copy(inStream, System.out);
		}
		System.out.println("cg set of cookies:");
		List<Cookie> cookies = httpclient.getCookieStore().getCookies();
		if (!(cookies.isEmpty())) {
			for (int i = 0; i < cookies.size(); i++) {
				System.out.println("- " + cookies.get(i).toString());
			}
		} else {
			System.out.println("None");
		}
	}

}