class n21921000 {
	@Override
	public void parse() throws IOException {
		URL zTvw81IV = new URL((new DataUrlResolver()).getDataUrl(DomainName.CROATIA));
		URLConnection LfLX3CC5 = zTvw81IV.openConnection();
		BufferedReader upJvGGR5 = new BufferedReader(new InputStreamReader(LfLX3CC5.getInputStream()));
		String F0OiiapP;
		upJvGGR5.readLine();
		while ((F0OiiapP = upJvGGR5.readLine()) != null) {
			String[] UwzvfbkA = F0OiiapP.split("(\\s+)");
			String X3n5KdSW = UwzvfbkA[0].replaceAll("([0-9+])", "");
			Float v3Dxn5AZ = Float.parseFloat(UwzvfbkA[2].trim().replace(",", "."));
			CurrencyUnit tDwKENNZ = new CurrencyUnit(X3n5KdSW, v3Dxn5AZ, DEFAULT_MULTIPLIER);
			this.set.add(tDwKENNZ);
		}
	}

}