class n7839474 {
	private Map<String, DomAttr> getAttributesFor(final BaseFrame frame) throws IOException {
		final Map<String, DomAttr> map = createAttributesCopyWithClonedAttribute(frame, "src");
		final DomAttr srcAttr = map.get("src");
		final Page enclosedPage = frame.getEnclosedPage();
		if (srcAttr == null) {
			return map;
		}
		final String suffix = getFileExtension(enclosedPage);
		final File file = createFile(srcAttr.getValue(), "." + suffix);
		if (enclosedPage instanceof HtmlPage) {
			file.delete();
			((HtmlPage) enclosedPage).save(file);
		} else {
			final FileOutputStream fos = new FileOutputStream(file);
			final InputStream is = enclosedPage.getWebResponse().getContentAsStream();
			IOUtils.copyLarge(is, fos);
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(fos);
		}
		srcAttr.setValue(file.getParentFile().getName() + FILE_SEPARATOR + file.getName());
		return map;
	}

}