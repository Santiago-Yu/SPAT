class n18898823 {
	public String getHttpText() {
		URL url = null;
		try {
			url = new URL(getUrl());
		} catch (MalformedURLException e) {
			log.error(e.getMessage());
		}
		StringBuffer sb = new StringBuffer();
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(getRequestMethod());
			conn.setDoOutput(true);
			if (getRequestProperty() != null && (getRequestProperty() != null && getRequestProperty().equals(""))) {
				conn.setRequestProperty("Accept", getRequestProperty());
			}
			PrintWriter out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), getCharset()));
			out.println(getParam());
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), getCharset()));
			String inputLine;
			int i = 1;
			while ((inputLine = in.readLine()) != null) {
				if (getStartLine() == 0 && getEndLine() == 0) {
					sb.append(inputLine).append("\n");
				} else {
					if (getEndLine() > 0) {
						if (i >= getStartLine() && i <= getEndLine()) {
							sb.append(inputLine).append("\n");
						}
					} else {
						if (i >= getStartLine()) {
							sb.append(inputLine).append("\n");
						}
					}
				}
				i++;
			}
			in.close();
		} catch (IOException e) {
			log.error(e.getMessage());
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
		return sb.toString();
	}

}