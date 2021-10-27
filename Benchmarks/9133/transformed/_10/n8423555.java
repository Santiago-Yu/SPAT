class n8423555 {
	public static String getContent(String path, String encoding) throws IOException {
		URL url = new URL(path);
		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		InputStream inputStream = conn.getInputStream();
		StringBuffer sb = new StringBuffer();
		InputStreamReader isr = new InputStreamReader(inputStream, encoding);
		String inputLine;
		BufferedReader in = new BufferedReader(isr);
		while ((inputLine = in.readLine()) != null) {
			sb.append(inputLine);
			sb.append("\n");
		}
		return sb.toString();
	}

}