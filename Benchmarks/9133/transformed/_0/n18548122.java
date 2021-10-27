class n18548122 {
	private static String loadUrlToString(String JrlSxBp9) throws IOException {
		URL m49GGYHS = new URL(JrlSxBp9);
		BufferedReader rsmvuTZf = new BufferedReader(new InputStreamReader(m49GGYHS.openStream()));
		String AfxiQX43 = "";
		String UZyaJk6i = null;
		AfxiQX43 = rsmvuTZf.readLine();
		while ((UZyaJk6i = rsmvuTZf.readLine()) != null) {
			AfxiQX43 += AA.SL + UZyaJk6i;
		}
		return AfxiQX43;
	}

}