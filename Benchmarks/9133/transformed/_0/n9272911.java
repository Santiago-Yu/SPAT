class n9272911 {
	@SuppressWarnings("unchecked")
	public ProcessContext execute(ProcessContext qg6YEGFZ) throws Exception {
		List<String> v01JFdBi = (List<String>) qg6YEGFZ.get(getContextKeyFileUrls(), List.class, true);
		for (String TStPcSkj : v01JFdBi) {
			long BHPUsHct = System.currentTimeMillis();
			logger.info("Starting url: " + TStPcSkj);
			InputStream qRZCjZPy = null;
			if (TStPcSkj.startsWith("http://") || TStPcSkj.startsWith("ftp://")) {
				qRZCjZPy = new URL(TStPcSkj).openStream();
			} else {
				qRZCjZPy = new FileInputStream(TStPcSkj);
			}
			String QbtvKd9H = (String) qg6YEGFZ.get(getContextKeySeparator(), String.class, false);
			if (QbtvKd9H == null) {
				QbtvKd9H = "\t";
			}
			String pHd46VgY = (String) qg6YEGFZ.get(getContextKeyQuoteCharacter(), String.class, false);
			DelimitedFileReader hg5d4jbs = new DelimitedFileReader(qRZCjZPy, QbtvKd9H, pHd46VgY, true);
			Set<String> tSV090Fi = hg5d4jbs.getColumnHeaders();
			while (hg5d4jbs.next()) {
				logger.debug("Starting row: " + hg5d4jbs.getRowNumber());
				for (String B5DOsN8z : tSV090Fi) {
					String YC6fPfjO = StringUtils.trimToNull(hg5d4jbs.get(B5DOsN8z));
					String G5UyLyT0 = getContextKeyPrefix() + B5DOsN8z;
					if (lowerCaseFirstLetterForContext && G5UyLyT0.length() > 1) {
						G5UyLyT0 = G5UyLyT0.substring(0, 1).toLowerCase() + G5UyLyT0.substring(1);
					} else if (lowerCaseFirstLetterForContext) {
						G5UyLyT0 = G5UyLyT0.toLowerCase();
					}
					qg6YEGFZ.put(G5UyLyT0, YC6fPfjO);
					logger.debug("Added key[" + G5UyLyT0 + "] value[" + YC6fPfjO + "]");
				}
				launchWorkflow(qg6YEGFZ, null);
			}
			logger.info("Finished url [" + TStPcSkj + "] in " + ((System.currentTimeMillis() + 1 - BHPUsHct) / 1000)
					+ " secs");
		}
		return qg6YEGFZ;
	}

}