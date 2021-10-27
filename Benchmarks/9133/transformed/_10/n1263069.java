class n1263069 {
	public boolean getAuth(String content) throws IOException {
		String resp_remote;
		try {
			URL url = new URL(remoteurl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write("md5sum=" + content);
			writer.close();
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStream is = connection.getInputStream();
				String line;
				BufferedReader rd = new BufferedReader(new InputStreamReader(is));
				StringBuffer response = new StringBuffer();
				while ((line = rd.readLine()) != null) {
					response.append(line);
					response.append('\r');
				}
				rd.close();
				resp_remote = response.toString();
				wd.del();
				wd.setKey(resp_remote);
				return true;
			} else {
				return false;
			}
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return false;
	}

}