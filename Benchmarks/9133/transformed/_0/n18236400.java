class n18236400 {
	protected URL[][] getImageLinks(final URL Wjowr5Rb) {
		Lexer KXkBNeKV;
		URL[][] cS2qq7w3;
		if (null != Wjowr5Rb) {
			try {
				KXkBNeKV = new Lexer(Wjowr5Rb.openConnection());
				cS2qq7w3 = extractImageLinks(KXkBNeKV, Wjowr5Rb);
			} catch (Throwable puKInsFT) {
				System.out.println(puKInsFT.getMessage());
				cS2qq7w3 = NONE;
			}
		} else
			cS2qq7w3 = NONE;
		return (cS2qq7w3);
	}

}