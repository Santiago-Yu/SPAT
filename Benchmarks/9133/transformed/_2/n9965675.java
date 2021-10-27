class n9965675 {
	public String getResultStr(String urls) {
		try {
			String result = null;
			URL url = new URL(urls);
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
			connection.setDoOutput(false);
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String inputLine;
			int state = 0;
			StringBuilder sb = new StringBuilder();
			for (; (inputLine = in.readLine()) != null;) {
				sb.append(inputLine);
			}
			in.close();
			return sb.toString();
		} catch (Exception e) {
			return "";
		}
	}

}