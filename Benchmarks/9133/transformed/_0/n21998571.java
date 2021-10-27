class n21998571 {
	private String readTwitterFead() {
		StringBuilder mVKRUxJa = new StringBuilder();
		HttpClient z37EN6FN = new DefaultHttpClient();
		HttpGet OWgROjRj = new HttpGet("http://twitter.com/statuses/user_timeline/vogella.json");
		try {
			HttpResponse vsJeY8Pd = z37EN6FN.execute(OWgROjRj);
			StatusLine kpFZKBxH = vsJeY8Pd.getStatusLine();
			int KgB2kTzV = kpFZKBxH.getStatusCode();
			if (KgB2kTzV == 200) {
				HttpEntity qyh0D7so = vsJeY8Pd.getEntity();
				InputStream VEv5LJYF = qyh0D7so.getContent();
				BufferedReader f6VTgHLR = new BufferedReader(new InputStreamReader(VEv5LJYF));
				String oeFiJZmR;
				while ((oeFiJZmR = f6VTgHLR.readLine()) != null) {
					mVKRUxJa.append(oeFiJZmR);
				}
			} else {
				Log.e(AndroidJsonTestingActivity.class.getName(), "Failed to download file");
			}
		} catch (ClientProtocolException NEHzIxZy) {
			NEHzIxZy.printStackTrace();
		} catch (IOException mAQgq8JR) {
			mAQgq8JR.printStackTrace();
		}
		return mVKRUxJa.toString();
	}

}