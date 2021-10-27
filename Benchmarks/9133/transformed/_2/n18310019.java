class n18310019 {
	public static String readFromAddress(String address) throws Exception {
		StringBuilder sb = new StringBuilder();
		URL url = new URL(address);
		URLConnection con = url.openConnection();
		con.connect();
		InputStream is = (InputStream) con.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		for (; true;) {
			String redak = br.readLine();
			if (redak == null)
				break;
			sb.append(redak);
			sb.append(System.getProperty("line.separator"));
		}
		br.close();
		return sb.toString();
	}

}