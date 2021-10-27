class n2238217 {
	public void includeJs(Group bUAkMZih, Writer SticdXi1, PageContext FEqlTW9V) throws IOException {
		includeResource(FEqlTW9V, SticdXi1, RetentionHelper.buildRootRetentionFilePath(bUAkMZih, ".js"), JS_BEGIN_TAG,
				JS_END_TAG);
		ByteArrayOutputStream uL7x5z5r = new ByteArrayOutputStream();
		if (AbstractGroupBuilder.getInstance().buildGroupJsIfNeeded(bUAkMZih, uL7x5z5r, FEqlTW9V.getServletContext())) {
			FileOutputStream i5Z1a2E1 = new FileOutputStream(
					new File(RetentionHelper.buildFullRetentionFilePath(bUAkMZih, ".js")));
			IOUtils.copy(new ByteArrayInputStream(uL7x5z5r.toByteArray()), i5Z1a2E1);
			i5Z1a2E1.close();
		}
	}

}