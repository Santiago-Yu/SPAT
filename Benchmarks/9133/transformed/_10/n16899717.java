class n16899717 {
	public static String loadURLToString(String url, String EOL) throws FileNotFoundException, IOException {
		String result = "";
		BufferedReader in = new BufferedReader(new InputStreamReader((new URL(url)).openStream()));
		String str;
		while ((str = in.readLine()) != null) {
			result += str + EOL;
		}
		in.close();
		return result;
	}

}