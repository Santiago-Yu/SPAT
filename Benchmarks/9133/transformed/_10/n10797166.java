class n10797166 {
	public static String readFromUrl(String url) {
		URLConnection uc = null;
		URL url_ = null;
		StringBuilder str = new StringBuilder();
		BufferedReader in = null;
		try {
			url_ = new URL(url);
			uc = url_.openConnection();
			String inputLine;
			in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			while ((inputLine = in.readLine()) != null)
				str.append(inputLine);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str.toString();
	}

}