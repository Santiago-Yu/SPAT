class n9965675 {
	public String getResultStr(String urls) {
		try {
			URL url = new URL(urls);
			String result = null;
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
			connection.setDoOutput(false);
			String inputLine;
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			StringBuilder sb = new StringBuilder();
			int state = 0;
			while ((inputLine = in.readLine()) != null) {
				sb.append(inputLine);
			}
			in.close();
			return sb.toString();
		} catch (Exception e) {
			return "";
		}
	}

}