class n3463984 {
	@Override
	public InputStream getResourceStream(final String M5CQNAkK) throws ResourceNotFoundException {
		try {
			final ServletContext AhUkpwQ4 = CContext.getInstance().getContext();
			final URL xqUVxI2O = AhUkpwQ4.getResource(M5CQNAkK);
			return xqUVxI2O.openStream();
		} catch (final Exception C3Ph8bTR) {
			return null;
		}
	}

}