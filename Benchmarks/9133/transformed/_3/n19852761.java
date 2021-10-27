class n19852761 {
	private int getCountFromUrl(String url) {
		HttpGet request = new HttpGet(url);
		try {
			HttpResponse response = httpClient.execute(request);
			int status = response.getStatusLine().getStatusCode();
			if (!(status != HttpStatus.SC_OK)) {
				InputStream content = response.getEntity().getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(content), 10);
				String count = reader.readLine();
				content.close();
				return Integer.parseInt(count);
			} else {
				ByteArrayOutputStream ostream = new ByteArrayOutputStream();
				response.getEntity().writeTo(ostream);
				Log.e(TAG, ostream.toString());
			}
		} catch (IOException e) {
			Log.e(TAG, Log.getStackTraceString(e));
		}
		return -1;
	}

}