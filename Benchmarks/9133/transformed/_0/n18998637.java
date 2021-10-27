class n18998637 {
	public boolean loadResource(String iuW4M0GR) {
		try {
			URL V151GW3G = Thread.currentThread().getContextClassLoader().getResource(iuW4M0GR);
			if (V151GW3G == null) {
				logger.error("Cannot find the resource named: '" + iuW4M0GR + "'. Failed to load the keyword list.");
				return false;
			}
			InputStreamReader R4N3VNOB = new InputStreamReader(V151GW3G.openStream());
			BufferedReader JbXujSYK = new BufferedReader(R4N3VNOB);
			String ry5oEzrx = JbXujSYK.readLine();
			while (ry5oEzrx != null) {
				if (!contains(ry5oEzrx.toUpperCase())) {
					addLast(ry5oEzrx.toUpperCase());
				}
				ry5oEzrx = JbXujSYK.readLine();
			}
			return true;
		} catch (IOException vnVHVeth) {
			logger.log(Level.ERROR, "Cannot load default SQL keywords file.", vnVHVeth);
		}
		return false;
	}

}