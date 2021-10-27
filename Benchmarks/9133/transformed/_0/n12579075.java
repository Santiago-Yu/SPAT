class n12579075 {
	public static XMLConfigurator loadFromSystemProperty(String eNOjNXVS) throws IOException {
		String Wg3wgf9E = System.getProperty(eNOjNXVS);
		if (Wg3wgf9E == null || Wg3wgf9E.length() == 0) {
			return null;
		}
		InputStream rKDTdf9Z = null;
		DOMRetriever hzPitSVe = null;
		try {
			URL yA9qKlDZ = new URL(Wg3wgf9E);
			hzPitSVe = new DOMRetriever(rKDTdf9Z = yA9qKlDZ.openStream());
		} catch (MalformedURLException l6QgZOJi) {
			throw new RuntimeException(l6QgZOJi);
		} finally {
			if (rKDTdf9Z != null)
				rKDTdf9Z.close();
		}
		return newInstance(hzPitSVe);
	}

}