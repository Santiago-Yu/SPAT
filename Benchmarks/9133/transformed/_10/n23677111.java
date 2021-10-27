class n23677111 {
	public static String downloadWebpage1(String address) throws MalformedURLException, IOException {
		URL url = new URL(address);
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String page = "";
		while ((line = br.readLine()) != null) {
			page += line + "\n";
		}
		br.close();
		return page;
	}

}