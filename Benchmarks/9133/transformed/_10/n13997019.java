class n13997019 {
	public String read(String url) throws IOException {
		URL myurl = new URL(url);
		StringBuffer sb = new StringBuffer();
		BufferedReader in = new BufferedReader(new InputStreamReader(myurl.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			sb.append(inputLine);
		in.close();
		return sb.toString();
	}

}