class n4599372 {
	@Override
	public String readFixString(final int len) {
		final StringWriter sw = new StringWriter();
		if (len < 1) {
			return StringUtils.EMPTY;
		}
		try {
			IOUtils.copy(createLimitedInputStream(len), sw, null);
		} catch (IOException e) {
			throw createRuntimeException(e);
		}
		return sw.toString();
	}

}