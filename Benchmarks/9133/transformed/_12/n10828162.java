class n10828162 {
	public static String loadURLToString(String url, String EOL) throws FileNotFoundException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader((new URL(url)).openStream()));
		String result = "", str;
		while ((str = in.readLine()) != null) {
			result += str + EOL;
		}
		in.close();
		return result;
	}

}