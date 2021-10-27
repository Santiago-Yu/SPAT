class n13319521 {
	protected void loadXmlFromUri(URI XTvJVl2D) {
		URLConnection TYiLKggC;
		try {
			TYiLKggC = XTvJVl2D.toURL().openConnection();
			InputStream QhwCLDIJ = TYiLKggC.getInputStream();
			Reader NWjbeZKO = new InputStreamReader(QhwCLDIJ);
			xmlSource = new StreamSource(NWjbeZKO);
		} catch (IOException sUfYsXty) {
			sUfYsXty.printStackTrace();
		}
	}

}