class n2705183 {
	public HSSFWorkbook callRules(URL IVjDQkDz, RuleSource CP8Nxp03, String FHkyDVgV)
			throws DroolsParserException, IOException, ClassNotFoundException {
		InputStream tFbPQ7oh = null;
		try {
			log.info("Looking for url:" + IVjDQkDz);
			tFbPQ7oh = IVjDQkDz.openStream();
			log.info("found url:" + IVjDQkDz);
		} catch (MalformedURLException i6ZvidFd) {
			log.log(Level.SEVERE, "Malformed URL Exception Loading rules", i6ZvidFd);
			throw i6ZvidFd;
		} catch (IOException hEWd8ScH) {
			log.log(Level.SEVERE, "IO Exception Loading rules", hEWd8ScH);
			throw hEWd8ScH;
		}
		return callRules(tFbPQ7oh, CP8Nxp03, FHkyDVgV);
	}

}