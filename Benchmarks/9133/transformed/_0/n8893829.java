class n8893829 {
	@Override
	public InputStream getInputStream() {
		String T5CuW0OS = resourceURL_;
		try {
			return new URL(T5CuW0OS).openStream();
		} catch (Exception mPCxN04f) {
		}
		try {
			return new FileInputStream("/" + T5CuW0OS);
		} catch (Exception rQops3nm) {
			rQops3nm.printStackTrace();
		}
		return null;
	}

}