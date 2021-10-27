class n20425837 {
	public static String loadSite(String spec) throws IOException {
		URL url = new URL(spec);
		String output = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String str;
		while ((str = in.readLine()) != null) {
			output += str + "\n";
		}
		in.close();
		return output;
	}

}