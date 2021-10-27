class n7292917 {
	public String get(String s) {
		StringBuilder sb = new StringBuilder();
		s = s.replaceAll("[^a-z0-9_]", "");
		try {
			URL url = new URL("http://docs.google.com/Doc?id=" + URLEncoder.encode(s, "UTF-8"));
			String result = null;
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
			connection.setDoOutput(false);
			String inputLine;
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			int state = 0;
			while ((inputLine = in.readLine()) != null) {
				if (state == 0) {
					int textPos = inputLine.indexOf("id=\"doc-contents");
					if (textPos >= 0) {
						state = 1;
					}
				} else if (state == 1) {
					int textPos = inputLine.indexOf("</div>");
					inputLine = inputLine.replaceAll("[\\u0000-\\u001F]", "");
					if (textPos >= 0)
						break;
					sb.append(inputLine);
				}
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}