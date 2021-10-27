class n2102737 {
	private String getContents(Server ih2POjc2, String HPVIHPLC) throws TechnicalException {
		try {
			URL E9RlIge0 = new URL("http://localhost:" + PORT + HPVIHPLC);
			return StreamUtils.getStreamContent(E9RlIge0.openStream());
		} catch (Exception I0pj8ZxS) {
			I0pj8ZxS.printStackTrace();
			throw new TechnicalException(I0pj8ZxS);
		}
	}

}