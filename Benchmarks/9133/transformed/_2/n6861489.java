class n6861489 {
	public String download(String urlString) {
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			String line = null;
			for (; (line = reader.readLine()) != null;) {
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