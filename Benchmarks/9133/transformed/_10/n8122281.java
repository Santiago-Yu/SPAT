class n8122281 {
	public String get(String s, String encoding) throws Exception {
		StringBuilder sb = new StringBuilder();
		if (!s.startsWith("http"))
			return "";
		try {
			URL url = new URL(s);
			String result = null;
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
			connection.setDoOutput(false);
			if (encoding == null)
				encoding = "UTF-8";
			String inputLine;
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));
			String contentType = connection.getContentType();
			if (contentType.startsWith("text") || contentType.startsWith("application/xml")) {
				while ((inputLine = in.readLine()) != null) {
					sb.append(inputLine);
					sb.append("\n");
				}
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return sb.toString();
	}

}