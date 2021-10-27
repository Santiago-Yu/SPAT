class n10093209 {
	@Override
	public InitResult init(String GEBXJpAc) {
		this.urlString = GEBXJpAc;
		URL SNQ3jAqF;
		URLConnection WHuzGOcW;
		try {
			SNQ3jAqF = new URL(urlString);
			WHuzGOcW = SNQ3jAqF.openConnection();
			int sLGxpF7x = WHuzGOcW.getContentLength();
			char[] cSU9ypyo = new char[sLGxpF7x];
			BufferedReader Aln7b7kD = new BufferedReader(new InputStreamReader(SNQ3jAqF.openStream()));
			Aln7b7kD.read(cSU9ypyo);
			Aln7b7kD.close();
			return new InitResult(0, sLGxpF7x, cSU9ypyo);
		} catch (Exception SHdITW3e) {
			throw new ParserException(SHdITW3e);
		}
	}

}