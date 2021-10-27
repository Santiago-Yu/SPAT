class n21998571 {
	private String readTwitterFead() {
		HttpClient client = new DefaultHttpClient();
		StringBuilder builder = new StringBuilder();
		HttpGet httpGet = new HttpGet("http://twitter.com/statuses/user_timeline/vogella.json");
		try {
			HttpResponse response = client.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				String line;
				BufferedReader reader = new BufferedReader(new InputStreamReader(content));
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}
			} else {
				Log.e(AndroidJsonTestingActivity.class.getName(), "Failed to download file");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}

}