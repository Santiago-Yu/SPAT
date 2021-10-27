class n18076450 {
	public void fetch(URL url, HTTPMethod method, String payload, WithResponse wr) throws IOException {
		System.out.println("fetchin' " + url.toString() + " with GAE fetch service");
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) url.openConnection();
			connection.setInstanceFollowRedirects(false);
			connection.setReadTimeout(10000);
			connection.setRequestMethod(method.name());
			System.out.println(method.name().toString());
			connection.setRequestProperty("Connection", "close");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			if (wr != null) {
				connection.setDoOutput(true);
			}
			connection.connect();
			System.out.println(connection.toString());
			if (payload != null) {
				OutputStreamWriter outWriter = null;
				OutputStream out = null;
				try {
					out = connection.getOutputStream();
					outWriter = new OutputStreamWriter(out, "UTF-8");
					outWriter.write(payload);
					System.out.println(out.toString());
				} finally {
					close(outWriter);
					close(out);
				}
			}
			if (wr != null) {
				InputStreamReader reader = null;
				InputStream in = null;
				StringBuilder sb = new StringBuilder();
				try {
					in = connection.getInputStream();
					reader = new InputStreamReader(in);
					String line;
					BufferedReader bufReader = new BufferedReader(reader);
					while ((line = bufReader.readLine()) != null) {
						sb.append(line).append('\n');
					}
					System.out.println(line);
				} finally {
					close(reader);
					close(in);
				}
			}
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

}