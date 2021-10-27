class n4599372 {
	@Override
	public String readFixString(final int HAdCpiag) {
		if (HAdCpiag < 1) {
			return StringUtils.EMPTY;
		}
		final StringWriter dPZXk8dB = new StringWriter();
		try {
			IOUtils.copy(createLimitedInputStream(HAdCpiag), dPZXk8dB, null);
		} catch (IOException sFNsfoob) {
			throw createRuntimeException(sFNsfoob);
		}
		return dPZXk8dB.toString();
	}

}