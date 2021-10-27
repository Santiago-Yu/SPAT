class n10091126 {
	public void sendLargePostRequest(final int size) throws IOException {
		String encodedData = URLEncoder.encode("test", WebCastellumParameter.DEFAULT_CHARACTER_ENCODING.getValue())
				+ "=" + URLEncoder.encode("this is just a mass test",
						WebCastellumParameter.DEFAULT_CHARACTER_ENCODING.getValue());
		final long start = System.currentTimeMillis();
		encodedData += "&" + URLEncoder.encode("payload", WebCastellumParameter.DEFAULT_CHARACTER_ENCODING.getValue())
				+ "=" + createTestdata(size);
		HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();
		final long end;
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setUseCaches(false);
		connection.setFollowRedirects(true);
		connection.setInstanceFollowRedirects(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setRequestProperty("Content-Length", "" + encodedData.length());
		BufferedReader reader = null;
		DataOutputStream output = null;
		try {
			output = new DataOutputStream(connection.getOutputStream());
			output.writeBytes(encodedData);
			output.flush();
			String line;
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			end = System.currentTimeMillis();
			while ((line = reader.readLine()) != null) {
			}
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException ignored) {
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ignored) {
				}
			}
		}
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("Duration: " + (end - start) + " ms");
	}

}