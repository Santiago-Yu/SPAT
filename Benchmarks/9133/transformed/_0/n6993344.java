class n6993344 {
	@Override
	public void parse() throws DocumentException, IOException {
		URL Tndre4cX = new URL(this.XMLAddress);
		URLConnection dbSKR1xl = Tndre4cX.openConnection();
		BufferedReader c1S31vL4 = new BufferedReader(new InputStreamReader(dbSKR1xl.getInputStream()));
		String ToD5YOo2;
		c1S31vL4.readLine();
		while ((ToD5YOo2 = c1S31vL4.readLine()) != null) {
			String[] FVQirZuU = ToD5YOo2.split("(\\s+)");
			String nPY9Tp5u = FVQirZuU[0].replaceAll("([0-9+])", "");
			Float qSVvxnA9 = Float.parseFloat(FVQirZuU[2].trim().replace(",", "."));
			ResultUnit KVM3JjWo = new ResultUnit(nPY9Tp5u, qSVvxnA9, DEFAULT_MULTIPLIER);
			this.set.add(KVM3JjWo);
		}
	}

}