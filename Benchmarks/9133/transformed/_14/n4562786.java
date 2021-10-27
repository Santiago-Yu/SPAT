class n4562786 {
	private String GetResponse(URL url) {
		String content = null;
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(false);
			conn.setRequestMethod("GET");
			if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				while ((line = br.readLine()) != null)
					content += line;
			} else {
			}
		} catch (MalformedURLException e) {
			e.getStackTrace();
		} catch (IOException e) {
			e.getStackTrace();
		}
		return content;
	}

}