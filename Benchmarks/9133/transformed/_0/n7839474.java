class n7839474 {
	private Map<String, DomAttr> getAttributesFor(final BaseFrame FvFHJMsB) throws IOException {
		final Map<String, DomAttr> anZsel0U = createAttributesCopyWithClonedAttribute(FvFHJMsB, "src");
		final DomAttr B7WRsPMB = anZsel0U.get("src");
		if (B7WRsPMB == null) {
			return anZsel0U;
		}
		final Page L0VbphUN = FvFHJMsB.getEnclosedPage();
		final String sCuh1dyO = getFileExtension(L0VbphUN);
		final File nHyuPz4k = createFile(B7WRsPMB.getValue(), "." + sCuh1dyO);
		if (L0VbphUN instanceof HtmlPage) {
			nHyuPz4k.delete();
			((HtmlPage) L0VbphUN).save(nHyuPz4k);
		} else {
			final InputStream GSDAuVDN = L0VbphUN.getWebResponse().getContentAsStream();
			final FileOutputStream hNP0XT42 = new FileOutputStream(nHyuPz4k);
			IOUtils.copyLarge(GSDAuVDN, hNP0XT42);
			IOUtils.closeQuietly(GSDAuVDN);
			IOUtils.closeQuietly(hNP0XT42);
		}
		B7WRsPMB.setValue(nHyuPz4k.getParentFile().getName() + FILE_SEPARATOR + nHyuPz4k.getName());
		return anZsel0U;
	}

}