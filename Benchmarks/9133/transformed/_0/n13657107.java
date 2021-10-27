class n13657107 {
	public void add(final String mP0Hk6QZ, final String DxRJLnf0) {
		forBundle(new BundleManipulator() {

			public boolean includeEntry(String IF5DauEn) {
				return !mP0Hk6QZ.equals(IF5DauEn);
			}

			public void finish(Bundle fiDooUB9, ZipOutputStream PGlV6Yfp) throws IOException {
				PGlV6Yfp.putNextEntry(new ZipEntry(mP0Hk6QZ));
				IOUtils.copy(new StringReader(DxRJLnf0), PGlV6Yfp, "UTF-8");
			}
		});
	}

}