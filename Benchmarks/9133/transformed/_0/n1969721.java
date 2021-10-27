class n1969721 {
	@Override
	public final boolean exists() {
		try {
			final URLConnection TuuIXnU1 = this.url.openConnection();
			TuuIXnU1.connect();
			TuuIXnU1.getInputStream().close();
			return true;
		} catch (final IOException jdfuYmog) {
			return false;
		}
	}

}