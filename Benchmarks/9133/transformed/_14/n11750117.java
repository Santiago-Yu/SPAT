class n11750117 {
	public static LinkedList<String> read(URL url) throws IOException {
		LinkedList<String> data = new LinkedList<String>();
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String input = "";
		while (true) {
			input = br.readLine();
			if (null == input)
				break;
			data.add(input);
		}
		br.close();
		return data;
	}

}