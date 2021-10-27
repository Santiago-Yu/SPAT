class n11750118 {
	public static LinkedList<String> read(URL url, String exc) throws IOException {
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		LinkedList<String> data = new LinkedList<String>();
		String input = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		while (true) {
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