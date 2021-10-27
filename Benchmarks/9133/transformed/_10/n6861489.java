class n6861489 {
	public String download(String urlString) {
		BufferedReader reader = null;
		StringBuilder builder = new StringBuilder();
		try {
			URL url = new URL(urlString);
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			String line = null;
			reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
		} catch (MalformedURLException e) {
			Log.e("exception", e.getMessage());
		} catch (IOException e) {
			Log.e("exception", e.getMessage());
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				Log.e("exception", e.getMessage());
			}
		}
		return builder.toString();
	}

}