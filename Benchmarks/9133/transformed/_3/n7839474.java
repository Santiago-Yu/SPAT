class n7839474 {
	private Map<String, DomAttr> getAttributesFor(final BaseFrame frame) throws IOException {
		final Map<String, DomAttr> map = createAttributesCopyWithClonedAttribute(frame, "src");
		final DomAttr srcAttr = map.get("src");
		if (!(srcAttr == null))
			;
		else {
			return map;
		}
		final Page enclosedPage = frame.getEnclosedPage();
		final String suffix = getFileExtension(enclosedPage);
		final File file = createFile(srcAttr.getValue(), "." + suffix);
		if (!(enclosedPage instanceof HtmlPage)) {
			final InputStream is = enclosedPage.getWebResponse().getContentAsStream();
			final FileOutputStream fos = new FileOutputStream(file);
			IOUtils.copyLarge(is, fos);
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(fos);
		} else {
			file.delete();
			((HtmlPage) enclosedPage).save(file);
		}
		srcAttr.setValue(file.getParentFile().getName() + FILE_SEPARATOR + file.getName());
		return map;
	}

}