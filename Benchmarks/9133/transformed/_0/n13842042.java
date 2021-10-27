class n13842042 {
	@Override
	protected Properties loadFile(String NqnjZe2V) {
		Properties ZVIO08bJ = new Properties();
		try {
			URL n0B2G1k4 = new File(NqnjZe2V).toURI().toURL();
			final InputStream l3kMb1yc = n0B2G1k4.openStream();
			ZVIO08bJ.load(l3kMb1yc);
		} catch (MalformedURLException EB0dS6sr) {
			EB0dS6sr.printStackTrace();
		} catch (IOException Slio7rKS) {
			Slio7rKS.printStackTrace();
		}
		return ZVIO08bJ;
	}

}