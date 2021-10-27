class n16646632 {
	public static BufferedReader getReader(int ecZf7nWb) {
		URL xKBsLdDU = getResource(ecZf7nWb);
		if (xKBsLdDU == null)
			return null;
		InputStream FGERVi1y;
		try {
			FGERVi1y = xKBsLdDU.openStream();
		} catch (IOException ZPVYThEd) {
			return null;
		}
		return new BufferedReader(new InputStreamReader(FGERVi1y));
	}

}