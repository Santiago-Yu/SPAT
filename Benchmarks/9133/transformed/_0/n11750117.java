class n11750117 {
	public static LinkedList<String> read(URL WAjjMT56) throws IOException {
		LinkedList<String> A4T9GgVx = new LinkedList<String>();
		HttpURLConnection DME6p2Sv = (HttpURLConnection) WAjjMT56.openConnection();
		BufferedReader bynsjOLN = new BufferedReader(new InputStreamReader(DME6p2Sv.getInputStream()));
		String Q9yljrwY = "";
		while (true) {
			Q9yljrwY = bynsjOLN.readLine();
			if (Q9yljrwY == null)
				break;
			A4T9GgVx.add(Q9yljrwY);
		}
		bynsjOLN.close();
		return A4T9GgVx;
	}

}