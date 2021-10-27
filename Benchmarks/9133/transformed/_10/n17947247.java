class n17947247 {
	public String postURL(String urlLocation, ArrayList headers, String content, HashMap postVariables, RenderEngine c)
			throws Exception {
		String postContent = null;
		if (postVariables != null) {
			postContent = new String();
			boolean firstElement = true;
			Iterator elements = postVariables.keySet().iterator();
			while (elements.hasNext()) {
				String key = (String) elements.next();
				String val = (String) postVariables.get(key);
				if (firstElement) {
					firstElement = false;
					postContent += Encoder.URLEncode(key) + "=" + Encoder.URLEncode(val);
				} else {
					postContent += "&" + Encoder.URLEncode(key) + "=" + Encoder.URLEncode(val);
				}
			}
			elements = null;
		} else {
			postContent = content;
		}
		Debug.log("Connecting to URL '" + urlLocation + "', content '" + postContent + "'");
		URL url = null;
		StringBuffer lines = new StringBuffer();
		try {
			url = new URL(urlLocation);
		} catch (MalformedURLException e) {
			Debug.log("Unable to retrieve URL '" + urlLocation + "': " + e.getMessage());
			return null;
		}
		boolean contentLengthFound = false;
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			loadCookies(urlLocation, conn, c);
			if (headers != null) {
				for (int i = 0; i < headers.size(); i++) {
					String header = (String) headers.get(i);
					String key = header.substring(0, header.indexOf(":"));
					if (key != null && key.equalsIgnoreCase("content-length")) {
						contentLengthFound = true;
					}
					String value = header.substring(header.indexOf(":") + 2);
					Debug.log("Adding new request header '" + key + "'='" + value + "'");
					conn.setRequestProperty(key, value);
				}
			}
			if (!contentLengthFound) {
				Debug.log("Adding new request header 'Content-Length'='" + postContent.length() + "'");
				conn.setRequestProperty("Content-Length", Integer.toString(postContent.length()));
			}
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(postContent);
			wr.flush();
			String line = null;
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				lines.append(line);
				lines.append("\r\n");
			}
			handleHeaders(urlLocation, conn.getHeaderFields());
			wr.close();
			rd.close();
			rd = null;
			wr = null;
		} catch (IOException e) {
			if (conn != null) {
				try {
					throw new Exception("Server returned error code '" + conn.getResponseCode() + "': "
							+ conn.getResponseMessage());
				} catch (IOException ee) {
					throw new Exception("Unable to report error codes: " + ee.getMessage());
				}
				lines = new StringBuffer();
			}
			Debug.log("I/O Exception occurred while communicating with endpoint: " + e.getMessage());
			return lines.toString().trim();
		} catch (Exception e) {
		}
		conn = null;
		url = null;
		return lines.toString().trim();
	}

}