class n21979462 {
	protected String downloadURLtoString(URL url) throws IOException {
		StringBuffer sb = new StringBuffer(100 * 1024);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String str;
		while ((str = in.readLine()) != null) {
			sb.append(str);
		}
		in.close();
		return sb.toString();
	}

}