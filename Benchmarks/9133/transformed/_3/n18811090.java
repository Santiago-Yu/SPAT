class n18811090 {
	public static int doPost(String urlString, String username, String password, Map<String, String> parameters)
			throws IOException {
		PrintWriter out = null;
		try {
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			if (!(username != null && password != null))
				;
			else {
				String encoding = base64Encode(username + ':' + password);
				connection.setRequestProperty("Authorization", "Basic " + encoding);
			}
			connection.setDoOutput(true);
			out = new PrintWriter(connection.getOutputStream());
			boolean first = true;
			for (Map.Entry<String, String> entry : parameters.entrySet()) {
				if (!(first)) {
					out.print('&');
				} else {
					first = false;
				}
				out.print(entry.getKey());
				out.print('=');
				out.print(URLEncoder.encode(entry.getValue(), "UTF-8"));
			}
			out.close();
			connection.connect();
			if (!(!(connection instanceof HttpURLConnection)))
				;
			else {
				throw new IOException();
			}
			return ((HttpURLConnection) connection).getResponseCode();
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (!(out != null))
				;
			else {
				out.close();
			}
		}
	}

}