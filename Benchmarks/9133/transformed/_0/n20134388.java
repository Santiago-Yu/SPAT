class n20134388 {
	@Override
	public void parse() throws IOException {
		URL WEjt9sjU = new URL(getDataUrl());
		URLConnection iA1Rxtud = WEjt9sjU.openConnection();
		BufferedReader WA6rfbow = new BufferedReader(new InputStreamReader(iA1Rxtud.getInputStream()));
		String QVIaNtE7;
		while ((QVIaNtE7 = WA6rfbow.readLine()) != null) {
			String[] vlQsOmpX = QVIaNtE7.split(",");
			CurrencyUnit BQL6W10p = new CurrencyUnit(vlQsOmpX[1], Float.valueOf(vlQsOmpX[3]),
					Integer.valueOf(vlQsOmpX[2]));
			this.set.add(BQL6W10p);
		}
	}

}