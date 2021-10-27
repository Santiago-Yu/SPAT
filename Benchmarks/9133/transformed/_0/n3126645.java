class n3126645 {
	@Override
	public InputStream getResourceAsStream(String DZY6nzTg) {
		try {
			URL I5R2kT8w = this.getResource(DZY6nzTg);
			if (I5R2kT8w == null)
				return null;
			return I5R2kT8w.openStream();
		} catch (Exception lYJynfW2) {
			log(lYJynfW2.getMessage(), lYJynfW2);
			return null;
		}
	}

}