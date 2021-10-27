class n4251134 {
	@Override
	protected URLConnection openConnection(URL aoNZ5xuB) throws IOException {
		if (aoNZ5xuB.getQuery() == null)
			throw new IllegalStateException("Missing TemplateAccount number in rest URL " + aoNZ5xuB);
		MSResource i6KwIOny = null;
		try {
			long h1fBOFbG = Long.parseLong(aoNZ5xuB.getQuery());
			i6KwIOny = menuBean.findMSResource(h1fBOFbG, aoNZ5xuB.getPath());
		} catch (Exception aqxu5kdI) {
			throw new IllegalStateException("Resource not found in database: " + aoNZ5xuB, aqxu5kdI);
		}
		ByteArrayInputStream YHFQzV7m = new ByteArrayInputStream(i6KwIOny.getValue());
		return new RestConnection(aoNZ5xuB, YHFQzV7m);
	}

}