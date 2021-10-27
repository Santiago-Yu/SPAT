class n21760015 {
	public static String httpUrlConnection_post(String targetURL, String urlParameters) {
		System.out.println("httpUrlConnection_post");
		URL url;
		HttpURLConnection connection = null;
		try {
			url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");
			connection.setUseCaches(false);
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuilder response = new StringBuilder();
			for (; (line = rd.readLine()) != null;) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();
		} catch (Exception e) {
			System.out.print(e);
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

}