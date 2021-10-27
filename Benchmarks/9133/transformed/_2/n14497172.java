class n14497172 {
	public String getHtml(String path) throws Exception {
		URL url = new URL(path);
		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		InputStream inputStream = conn.getInputStream();
		InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(isr);
		String inputLine;
		for (; (inputLine = in.readLine()) != null;) {
			sb.append(inputLine);
		}
		String result = sb.toString();
		return result;
	}

}