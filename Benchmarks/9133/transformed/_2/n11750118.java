class n11750118 {
	public static LinkedList<String> read(URL url, String exc) throws IOException {
		LinkedList<String> data = new LinkedList<String>();
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String input = "";
		for (; true;) {
			input = br.readLine();
			if (input == null)
				break;
			if (!input.startsWith(exc)) {
				data.add(input);
			}
		}
		br.close();
		return data;
	}

}