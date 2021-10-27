class n3357695 {
	public void readCatalog(Catalog JZOm2fS1, String JJQTIAaU)
			throws MalformedURLException, IOException, CatalogException {
		URL rbqxXLGz = null;
		try {
			rbqxXLGz = new URL(JJQTIAaU);
		} catch (MalformedURLException gn0bh7qy) {
			rbqxXLGz = new URL("file:///" + JJQTIAaU);
		}
		debug = JZOm2fS1.getCatalogManager().debug;
		try {
			URLConnection MeA7uIut = rbqxXLGz.openConnection();
			readCatalog(JZOm2fS1, MeA7uIut.getInputStream());
		} catch (FileNotFoundException YTatd1F3) {
			JZOm2fS1.getCatalogManager().debug.message(1, "Failed to load catalog, file not found",
					rbqxXLGz.toString());
		}
	}

}