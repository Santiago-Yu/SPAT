class n21921000 {
	@Override
	public void parse() throws IOException {
		URL url = new URL((new DataUrlResolver()).getDataUrl(DomainName.CROATIA));
		URLConnection con = url.openConnection();
		String str;
		BufferedReader bStream = new BufferedReader(new InputStreamReader(con.getInputStream()));
		bStream.readLine();
		while ((str = bStream.readLine()) != null) {
			String[] tokens = str.split("(\\s+)");
			String charCode = tokens[0].replaceAll("([0-9+])", "");
			Float value = Float.parseFloat(tokens[2].trim().replace(",", "."));
			CurrencyUnit unit = new CurrencyUnit(charCode, value, DEFAULT_MULTIPLIER);
			this.set.add(unit);
		}
	}

}