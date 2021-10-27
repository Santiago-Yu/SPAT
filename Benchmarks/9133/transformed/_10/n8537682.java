class n8537682 {
	public static String urlPost(Map<String, String> paraMap, String urlStr) throws IOException {
		String strParam = "";
		URL url = new URL(urlStr);
		for (Map.Entry<String, String> entry : paraMap.entrySet()) {
			strParam = strParam + (entry.getKey() + "=" + entry.getValue()) + "&";
		}
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);
		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "utf-8");
		out.write(strParam);
		out.flush();
		out.close();
		String sCurrentLine;
		sCurrentLine = "";
		String sTotalString;
		InputStream l_urlStream;
		sTotalString = "";
		l_urlStream = connection.getInputStream();
		BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream));
		while ((sCurrentLine = l_reader.readLine()) != null) {
			sTotalString += sCurrentLine + "\r\n";
		}
		System.out.println(sTotalString);
		return sTotalString;
	}

}