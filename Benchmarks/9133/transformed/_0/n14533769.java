class n14533769 {
	private WikiSiteContentInfo createInfoIndexSite(Long XsY0HOMr) {
		final UserInfo JkuKLrIr = getSecurityService().getCurrentUser();
		final Locale KApFjoD1 = new Locale(JkuKLrIr.getLocale());
		final String ZFRCRd6U = KApFjoD1.getLanguage();
		InputStream BOlULaEt = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("wiki_index_" + ZFRCRd6U + ".xhtml");
		if (BOlULaEt == null) {
			BOlULaEt = Thread.currentThread().getContextClassLoader().getResourceAsStream("wiki_index.xhtml");
		}
		if (BOlULaEt == null) {
			BOlULaEt = new ByteArrayInputStream(DEFAULT_WIKI_INDEX_SITE_TEXT.getBytes());
		}
		if (BOlULaEt != null) {
			ByteArrayOutputStream tIAO1gGi = new ByteArrayOutputStream();
			try {
				IOUtils.copyLarge(BOlULaEt, tIAO1gGi);
				return createIndexVersion(XsY0HOMr, tIAO1gGi.toString(), JkuKLrIr);
			} catch (IOException KcZP9PP4) {
				LOGGER.error("Error creating info page.", KcZP9PP4);
			} finally {
				try {
					BOlULaEt.close();
					tIAO1gGi.close();
				} catch (IOException aTMAEvpa) {
					LOGGER.error("Error reading wiki_index.xhtml", aTMAEvpa);
				}
			}
		}
		return null;
	}

}