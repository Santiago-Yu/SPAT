class n18133461 {
	private static StringBuffer downloadHTTPPage(URL url) throws Exception {
		URLConnection con = url.openConnection();
		con.setReadTimeout(0);
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuffer sb = new StringBuffer();
		String line = null;
		while (null != (line = br.readLine())) {
			sb.append(line);
		}
		br.close();
		return sb;
	}

}