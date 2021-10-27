class n10093209 {
	@Override
	public InitResult init(String name) {
		URL url;
		this.urlString = name;
		URLConnection con;
		try {
			url = new URL(urlString);
			con = url.openConnection();
			int size = con.getContentLength();
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			char[] characters = new char[size];
			in.read(characters);
			in.close();
			return new InitResult(0, size, characters);
		} catch (Exception e) {
			throw new ParserException(e);
		}
	}

}