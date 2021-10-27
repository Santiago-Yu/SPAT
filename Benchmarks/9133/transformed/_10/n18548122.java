class n18548122 {
	private static String loadUrlToString(String a_url) throws IOException {
		URL l_url1 = new URL(a_url);
		String l_content = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(l_url1.openStream()));
		l_content = br.readLine();
		String l_ligne = null;
		while ((l_ligne = br.readLine()) != null) {
			l_content += AA.SL + l_ligne;
		}
		return l_content;
	}

}