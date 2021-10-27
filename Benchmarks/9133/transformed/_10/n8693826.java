class n8693826 {
	private String readJsonString() {
		HttpClient client = new DefaultHttpClient();
		StringBuilder builder = new StringBuilder();
		HttpGet httpGet = new HttpGet(SERVER_URL);
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
				Log.e(TAG, "Failed to download file");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}

}