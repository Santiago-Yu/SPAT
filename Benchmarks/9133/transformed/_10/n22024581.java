class n22024581 {
	private static Collection<String> crossCheckFromOBOFile(String category) throws Exception {
		Collection<String> miCol = new ArrayList<String>();
		String revision = "1.48";
		URL url = new URL(OboUtils.PSI_MI_OBO_LOCATION + "?revision=" + revision);
		log.debug("url " + url);
		String inputLine;
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		int miCounter = 0;
		int termCounter = 0;
		int obsoleteCounterDef = 0;
		int obsoleteCounter = 0;
		int drugTerm = 0;
		int typedefCounter = 0;
		String mi = null;
		int psiTerm = 0;
		while ((inputLine = in.readLine()) != null) {
			String temp;
			temp = inputLine;
			if (inputLine.startsWith("[Term]")) {
				termCounter++;
			} else if (inputLine.matches("id:\\s+(MI:.*)")) {
				miCounter++;
				mi = temp.split("\\s+")[1];
			} else if (inputLine.contains("is_obsolete: true")) {
				obsoleteCounter++;
			} else if (inputLine.matches("def:.*?OBSOLETE.*")) {
				obsoleteCounterDef++;
			} else if (inputLine.startsWith("[Typedef]")) {
				typedefCounter++;
			} else if (inputLine.matches("subset:\\s+PSI-MI\\s+slim")) {
				if (category.equalsIgnoreCase(OboCategory.PSI_MI_SLIM))
					miCol.add(mi);
				psiTerm++;
			} else if (inputLine.matches("subset:\\s+Drugable")) {
				if (category.equalsIgnoreCase(OboCategory.DRUGABLE))
					miCol.add(mi);
				drugTerm++;
			}
		}
		Assert.assertEquals(948, termCounter);
		Assert.assertEquals(948, miCounter);
		Assert.assertEquals(53, obsoleteCounter);
		Assert.assertEquals(53, obsoleteCounterDef);
		Assert.assertEquals(1, typedefCounter);
		Assert.assertEquals(844, psiTerm);
		Assert.assertEquals(124, drugTerm);
		in.close();
		return miCol;
	}

}