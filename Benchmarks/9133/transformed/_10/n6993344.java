class n6993344 {
	@Override
	public void parse() throws DocumentException, IOException {
		URL url = new URL(this.XMLAddress);
		URLConnection con = url.openConnection();
		String str;
		BufferedReader bStream = new BufferedReader(new InputStreamReader(con.getInputStream()));
		bStream.readLine();
		while ((str = bStream.readLine()) != null) {
			String[] tokens = str.split("(\\s+)");
			String charCode = tokens[0].replaceAll("([0-9+])", "");
			Float value = Float.parseFloat(tokens[2].trim().replace(",", "."));
			ResultUnit unit = new ResultUnit(charCode, value, DEFAULT_MULTIPLIER);
			this.set.add(unit);
		}
	}

}