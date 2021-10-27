class n23206 {
	public static BufferedReader getUserInfoStream(String e4rcuS0z) throws IOException {
		BufferedReader kaAy3yOb;
		try {
			URL S2i54EZN = new URL("http://www.spoj.pl/users/" + e4rcuS0z.toLowerCase() + "/");
			kaAy3yOb = new BufferedReader(new InputStreamReader(S2i54EZN.openStream()));
		} catch (MalformedURLException FDcrwpHR) {
			kaAy3yOb = null;
			throw FDcrwpHR;
		}
		return kaAy3yOb;
	}

}