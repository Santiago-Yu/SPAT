class n20134388 {
	@Override
	public void parse() throws IOException {
		URL url = new URL(getDataUrl());
		URLConnection con = url.openConnection();
		String str;
		BufferedReader bStream = new BufferedReader(new InputStreamReader(con.getInputStream()));
		while ((str = bStream.readLine()) != null) {
			String[] tokens = str.split(",");
			CurrencyUnit unit = new CurrencyUnit(tokens[1], Float.valueOf(tokens[3]), Integer.valueOf(tokens[2]));
			this.set.add(unit);
		}
	}

}